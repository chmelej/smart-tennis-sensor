package p000;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.InputDeviceCompat;

/* JADX INFO: compiled from: GattError.java */
/* JADX INFO: loaded from: classes.dex */
public class amc {
    /* JADX INFO: renamed from: a */
    public static String m1930a(int i) {
        if (i == 8) {
            return "GATT CONN TIMEOUT";
        }
        if (i == 19) {
            return "GATT CONN TERMINATE PEER USER";
        }
        if (i == 22) {
            return "GATT CONN TERMINATE LOCAL HOST";
        }
        if (i == 34) {
            return "GATT CONN LMP TIMEOUT";
        }
        if (i == 62) {
            return "GATT CONN FAIL ESTABLISH";
        }
        if (i == 133) {
            return "GATT ERROR";
        }
        if (i == 256) {
            return "GATT CONN CANCEL ";
        }
        switch (i) {
            case 0:
                return ard.f4846g;
            case 1:
                return "GATT CONN L2C FAILURE";
            default:
                return "UNKNOWN (" + i + ")";
        }
    }

    /* JADX INFO: renamed from: b */
    public static String m1931b(int i) {
        if (i == 257) {
            return "TOO MANY OPEN CONNECTIONS";
        }
        if (i == 4110) {
            return "DFU DEVICE NOT BONDED";
        }
        switch (i) {
            case 1:
                return "GATT INVALID HANDLE";
            case 2:
                return "GATT READ NOT PERMIT";
            case 3:
                return "GATT WRITE NOT PERMIT";
            case 4:
                return "GATT INVALID PDU";
            case 5:
                return "GATT INSUF AUTHENTICATION";
            case 6:
                return "GATT REQ NOT SUPPORTED";
            case 7:
                return "GATT INVALID OFFSET";
            case 8:
                return "GATT INSUF AUTHORIZATION";
            case 9:
                return "GATT PREPARE Q FULL";
            case 10:
                return "GATT NOT FOUND";
            case 11:
                return "GATT NOT LONG";
            case 12:
                return "GATT INSUF KEY SIZE";
            case 13:
                return "GATT INVALID ATTR LEN";
            case 14:
                return "GATT ERR UNLIKELY";
            case 15:
                return "GATT INSUF ENCRYPTION";
            case 16:
                return "GATT UNSUPPORT GRP TYPE";
            case 17:
                return "GATT INSUF RESOURCE";
            default:
                switch (i) {
                    case 128:
                        return "GATT NO RESOURCES";
                    case 129:
                        return "GATT INTERNAL ERROR";
                    case 130:
                        return "GATT WRONG STATE";
                    case 131:
                        return "GATT DB FULL";
                    case 132:
                        return "GATT BUSY";
                    case 133:
                        return "GATT ERROR";
                    case 134:
                        return "GATT CMD STARTED";
                    case 135:
                        return "GATT ILLEGAL PARAMETER";
                    case 136:
                        return "GATT PENDING";
                    case 137:
                        return "GATT AUTH FAIL";
                    case 138:
                        return "GATT MORE";
                    case 139:
                        return "GATT INVALID CFG";
                    case 140:
                        return "GATT SERVICE STARTED";
                    case 141:
                        return "GATT ENCRYPTED NO MITM";
                    case 142:
                        return "GATT NOT ENCRYPTED";
                    case 143:
                        return "GATT CONGESTED";
                    default:
                        switch (i) {
                            case 253:
                                return "GATT CCCD CFG ERROR";
                            case 254:
                                return "GATT PROCEDURE IN PROGRESS";
                            case 255:
                                return "GATT VALUE OUT OF RANGE";
                            default:
                                switch (i) {
                                    case 4096:
                                        return "DFU DEVICE DISCONNECTED";
                                    case FragmentTransaction.TRANSIT_FRAGMENT_OPEN /* 4097 */:
                                        return "DFU FILE NOT FOUND";
                                    case InputDeviceCompat.SOURCE_TOUCHSCREEN /* 4098 */:
                                        return "DFU FILE ERROR";
                                    case FragmentTransaction.TRANSIT_FRAGMENT_FADE /* 4099 */:
                                        return "DFU NOT A VALID HEX FILE";
                                    case 4100:
                                        return "DFU IO EXCEPTION";
                                    case 4101:
                                        return "DFU SERVICE DISCOVERY NOT STARTED";
                                    case 4102:
                                        return "DFU SERVICE NOT FOUND";
                                    case 4103:
                                        return "DFU CHARACTERISTICS NOT FOUND";
                                    case 4104:
                                        return "DFU INVALID RESPONSE";
                                    case 4105:
                                        return "DFU FILE TYPE NOT SUPPORTED";
                                    case 4106:
                                        return "BLUETOOTH ADAPTER DISABLED";
                                    case 4107:
                                        return "INIT PACKET REQUIRED";
                                    case 4108:
                                        return "DFU FILE NOT WORD ALIGNED";
                                    default:
                                        if ((i & 8192) > 0) {
                                            return amd.m1932a(i);
                                        }
                                        return "UNKNOWN (" + i + ")";
                                }
                        }
                }
        }
    }
}
