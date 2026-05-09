# Bluetooth Protocol Documentation

Tento dokument popisuje komunikaci přes Bluetooth Low Energy (BLE) se Smart Tennis senzorem, na základě reverzního inženýrství dekompilované Android aplikace.

## 1. BLE Architektura a UUID

Aplikace používá standardní Android BLE API. Hlavní služba pro obsluhu Bluetooth je `com.coollang.tennis.blemanager.RFStarBLEService`, která řídí připojení a přenos dat. `C1840jx` (CubicBLEDevice) dědí od `AbstractC1838jv` a je zodpovědná za mapování služeb a zápis/čtení charakteristik.

### UUID služeb a charakteristik

16-bitové UUID jsou mapovány přes částečnou shodu prefixu. Konkrétní UUID se liší podle typu připojeného zařízení (`devicetype` začínající na "A...", "KU...", "M...").
Kód dynamicky vyhledává charakteristiky porovnáním prvních 4 znaků (16-bitové ID) přes `substring(0, 4)` ve třídě `C1840jx.java`.

**Typ zařízení "A" (A-Series):**
*(Definováno v `C1844ka.java` a `C1853kj.java`)*
- **Služba pro čtení (Read/Notify):** `1000` (`C1853kj.f10919a`)
- **Charakteristika pro čtení (Notify):** `3000` (`C1853kj.f10920b`)
- **Služba pro zápis (Write):** `1000` (`C1853kj.f10922d`)
- **Charakteristika pro zápis:** `2000` (`C1853kj.f10923e`)
- **Identifikátor pro příjem zpráv:** `0003` (`C1853kj.f10921c`) - slouží k validaci příchozích dat (`ACTION_DATA_AVAILABLE`)

**Typ zařízení "KU" nebo "M":**
*(Definováno v `C1844ka.java`)*
- **Služba pro čtení (Read/Notify):** `ffe0`
- **Charakteristika pro čtení (Notify):** `ffe4`
- **Služba pro zápis (Write):** `ffe5`
- **Charakteristika pro zápis:** `ffe9`
- **Identifikátor pro příjem zpráv:** `ffe4`

### Povolení Notifikací
Po připojení aplikace zapíše hodnotu `01 00` (BluetoothGattDescriptor.ENABLE_NOTIFICATION_VALUE) do Client Characteristic Configuration Descriptoru (CCCD) s UUID `00002902-0000-1000-8000-00805F9B34FB` u Notify charakteristiky, aby povolila příjem dat ze senzoru (viz `RFStarBLEService.java:202`).


## 2. Odesílání příkazů (Write Protokol)

Aplikace posílá příkazy do senzoru zápisem do "Write" charakteristiky. Veškeré příkazy jsou formátovány jako **20-bytové pakety**.

### Struktura paketu
Všechny příkazy, generované přes metody ve třídě `C1893lw.m10455c(byte[])`, sdílí tuto strukturu:
- **Byte 0:** `0xA8` (Zapsáno jako `-88` v signed 8-bit reprezentaci, `168` v unsigned). Toto je konstantní hlavička každého paketu.
- **Byte 1:** Kód příkazu.
- **Byte 2-6:** Payload (Volitelné parametry v závislosti na kódu příkazu).
- **Byte 7-18:** Padding (Výplň nulami `0x00`).
- **Byte 19:** Kontrolní součet (Checksum). Počítá se jako součet všech předchozích bytů (Byte 0 až Byte 18) s aplikováním bitové masky `& 0xFF` (pouze spodních 8 bitů) - viz metoda `C1893lw.m10451b`.

### Známé odesílané příkazy
Tyto příkazy jsou do senzoru odesílány prostřednictvím volání `C1839jw.m10042a(byte...)` napříč aplikací:

*   **Příkaz `0x01` (1) a `0x02` (2):** Pravděpodobně spuštění/zastavení záznamu sportovní aktivity (Voláno v `SportMainFragment.java:1464, 1443`).
*   **Příkaz `0x03` (3):** Aktualizace konfigurace ruky. (Voláno v `C1839jw.java:138` a `C1827jk.java:571`).
    *   *Parametry:* Byte 2 je nastaven na `0` nebo `1` v závislosti na tom, zda hráč hraje pravou nebo levou rukou (parsováno z "errDesc.Hand").
*   **Příkaz `0x04` (4):** Obnovení továrního nastavení (Factory Reset) / vyčištění dat (Voláno v `SettingActivity.java:328`).
*   **Příkaz `0x05` (5):** Přepnutí do režimu aktualizace firmware (OTA / DFU). (Voláno v `UpdateDeviceActivity.java`).
    *   *Parametry:* Podle typu zařízení se posílají dodatečné parametry, např. `0x05, 0x02, 0x00` nebo `0x01` / `0x02` / `0xFE` (-2) / `0x05`. Více viz sekce OTA aktualizace níže.
*   **Příkaz `0x11` (17):** Synchronizace času na senzoru. (Voláno v `C1842jz.java:110`, `SportMainFragment.java:963`).
    *   *Parametry:* Byty 2-5 obsahují 32-bitový timestamp (generováno pomocí `C1893lw.m10450a(long j)`).
*   **Příkaz `0x21` (33):** Dotaz na stav zařízení nebo verzi firmwaru. (Voláno v `SportMainFragment.java:464`, `UpdateDeviceActivity.java:354`).
*   **Příkaz `0x22` (34):** Vyžádání aktuálního stavu baterie senzoru. (Voláno v `SportMainFragment.java:500, 1403`).
*   **Příkaz `0x23` (35):** Vyžádání oflfine datové historie. (Voláno v `C1839jw.java:97`).
*   **Příkaz `0x24` (36):** Další příkaz spojený s off-line daty / záznamem. Často odesílán s parametrem `0x02` (např. `36, 2`) (Voláno v `VideoCaptureView.java:415, 592`, `TrainOnTimeActivity.java:228, 716`).
*   **Příkaz `0x25` (37):** Potvrzení nebo vyžádání specifického bloku detailních dat. (Voláno v `C1839jw.java:449` s formatem `m10042a(37, byte, byte, byte, byte)`).

### Změna názvu senzoru
Pokud chce uživatel senzor přejmenovat, generuje aplikace specifický 20-bytový paket (viz `C1839jw.java:261-280`):
- Byte 0: `0xA8` (`-88`)
- Byte 1: `0x12` (`18`)
- Byte 2-17: Nový název v ASCII (zbytek jména do 16 bytů je vyplněn mezerami `0x20`).
- Byte 19: Kontrolní součet (Checksum).


## 3. Přijímání a zpracování dat (Read/Notify Protokol)

Data obdržená ze senzoru notifikacemi (intent `ACTION_DATA_AVAILABLE`) jsou parsována převážně ve třídě `C1839jw.java`. Senzor posílá data ve stejném formátu jako přijímá – v **20-bytových paketech**:
- **Byte 0:** `0xA8` (`-88`)
- **Byte 1:** Kód odpovědi
- **Byte 2-18:** Obsah odpovědi (payload)
- **Byte 19:** Kontrolní součet (Checksum)

### Známé odpovědi ze senzoru

#### 1. Základní stavy a systémové zprávy
*   **Odpověď `0x01` / `0x02`:** Indikuje zastavení nebo spuštění stavu na senzoru. V aplikaci obvykle vede k odpojení nebo resetu UI stavu.
*   **Odpověď `0x03`:** Úspěšné vymazání dat ze senzoru.
*   **Odpověď `0x04`:** Úspěšné obnovení do továrního nastavení.
*   **Odpověď `0x11` (17):** Potvrzení synchronizace času. Byty 2-5 obsahují timestamp vrácený zařízením, podle kterého se aplikace kalibruje.
*   **Odpověď `0x12` (18):** Potvrzení změny názvu senzoru. Byty 2-17 obsahují úspěšně nastavené nové jméno.
*   **Odpověď `0x21` (33):** Odpověď s verzí firmware/zařízení. Byty 2-15 jsou aplikací parsovány jako ASCII string a zobrazeny v UI.
*   **Odpověď `0x22` (34):** Stav nabití baterie. Byte 2 obsahuje přímo procentuální hodnotu (0-100) baterie.

#### 2. Přehled offline historie (Kód `0x23` - 35)
Pokud senzor odpovídá kódem `0x23`, posílá shrnutí uložené offline historie. Byte 2 funguje jako identifikátor sub-typu (podpříkaz):
*   **Sub-typ `0x01`:** Přenos "hlavních dat" (Main Data).
    *   `Byte 3-4`: Datum.
    *   `Byte 5-6`: ID nebo počet neznámé metriky (`iM10453b`).
    *   `Byte 7-8`: Celkový počet úderů / švihů pro daný den (`iM10453b2`).
    *   `Byte 9-10`: Další neznámá metrika (`iM10453b3`).
*   **Sub-typ `0x02`:** Detailní statistika typů úderů pro konkrétní záznam. Každá hodnota je 16-bitová (`C1893lw.m10453b`):
    *   `Byte 3-4`: **Faqiu** (Počet podání / Serve).
    *   `Byte 5-6`: **Gaoya** (Počet smečí / Smash).
    *   `Byte 7-8`: **Jieji** (Počet volejů / Volley).
    *   `Byte 9-10`: **Xiaoqiu** (Počet kraťasů nebo čopů / Slice).
    *   `Byte 11-12`: **Xuanqiu** (Počet topspinů).
    *   `Byte 13-14`: **Pingji** (Počet rovných, plochých úderů / Flat).
*   **Sub-typ `0x03`:** Indikuje ukončení přenosu shrnutí offline historie.

#### 3. Detailní data o jednotlivých úderech (Kód `0x25` - 37)
Když si uživatel nebo aplikace vyžádá kompletní detailní záznam (Match Data), senzor streamuje informace pomocí kódu `0x25`. Toto komplexní parsování probíhá ve třídě `HandlerC1841jy.java`.
*   **Sub-typ `0x01` (v Byte 2):** Přenáší informace o jednom konkrétním úderu.
    *   `Byte 3`: Typ úderu (např. Forehand, Backhand, Servis).
    *   `Byte 4-5`: Hodnota (pravděpodobně rychlost - Speed).
    *   `Byte 6-7`: Hodnota (pravděpodobně rotace/spin).
    *   `Byte 8-9`: Další hodnota (síla nebo úhel odpalu).
    *   `Byte 10`: Boolean příznak (`1` nebo `0`). Může indikovat trefení "Sweet spotu".
    *   `Byte 11-14`: 32-bitový časový údaj (Timestamp) tohoto úderu, definován jako sekundy od definované epochy zařízení.
    *   `Byte 16`: Kalibrační nebo interní stavový byte.
    *   `Byte 17-18`: Další 16-bitová metrika spojená s úderem.
*   **Sub-typ `0x02`:** Tento paket indikuje úspěšný konec stahování detailních dat.


## 4. OTA Firmware Aktualizace

Aplikace pro senzor podporuje funkci Over-The-Air (OTA) aktualizace firmwaru a k tomuto účelu využívá populární knihovnu **Nordic Semiconductor DFU (Device Firmware Update)**.

Pro přepnutí běžícího senzoru do aktualizačního režimu (DFU módu) zapíše aplikace příkaz `0x05` s několika speciálními parametry definovanými podle typu zařízení:
- Forma příkazu: `[0xA8, 0x05, 0x02, <parametr_typu_zarizeni>, 0x00, 0x00... <checksum>]`
- Mapování `<parametr_typu_zarizeni>` na základě hodnoty `devicetype` v aplikaci (viz `UpdateDeviceActivity.java:275-284`):
    - Typ `"T0"` -> pošle parametr `0`
    - Typ `"T1"` -> pošle parametr `1`
    - Typ `"T2"` -> pošle parametr `2`
    - Typ `"TS"` -> pošle parametr `-2` (což je v bytech `0xFE`)
    - Typ `"T5"` -> pošle parametr `5`

Po odeslání tohoto příkazu se senzor restartuje a přejde do stavu Bootloader. Od tohoto momentu zmizí standardní tenisové služby a senzor začne broadcastovat standardní Nordic DFU službu (s UUID `00001530-1212-EFDE-1523-785FEABCD123`). Knihovna od Nordic Semiconductor v aplikaci následně naváže spojení a řídí bezpečný přenos `.zip` souboru s novým firmwarem.
