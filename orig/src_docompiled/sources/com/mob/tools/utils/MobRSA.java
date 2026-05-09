package com.mob.tools.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.SecureRandom;

/* JADX INFO: loaded from: classes.dex */
public class MobRSA {
    private int keySize;

    public MobRSA(int i) {
        this.keySize = i;
    }

    public BigInteger[] genKeys() {
        SecureRandom secureRandom = new SecureRandom();
        return genKeys(BigInteger.probablePrime((this.keySize / 2) - 1, secureRandom), BigInteger.probablePrime((this.keySize / 2) - 1, secureRandom), BigInteger.probablePrime(this.keySize / 2, secureRandom));
    }

    public BigInteger[] genKeys(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) throws Throwable {
        if (bigInteger3.compareTo(BigInteger.ONE) <= 0) {
            throw new Throwable("e must be larger than 1");
        }
        BigInteger[] bigIntegerArr = new BigInteger[3];
        BigInteger bigIntegerMultiply = bigInteger.multiply(bigInteger2);
        BigInteger bigIntegerAdd = bigIntegerMultiply.subtract(bigInteger).subtract(bigInteger2).add(BigInteger.ONE);
        if (bigInteger3.compareTo(bigIntegerAdd) >= 0) {
            throw new Throwable("e must be smaller than (p-1)*(q-1)");
        }
        if (bigIntegerAdd.gcd(bigInteger3).compareTo(BigInteger.ONE) != 0) {
            throw new Throwable("e must be coprime with (p-1)*(q-1)");
        }
        BigInteger bigIntegerModInverse = bigInteger3.modInverse(bigIntegerAdd);
        bigIntegerArr[0] = bigInteger3;
        bigIntegerArr[1] = bigIntegerModInverse;
        bigIntegerArr[2] = bigIntegerMultiply;
        return bigIntegerArr;
    }

    public byte[] encode(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws Throwable {
        int i = this.keySize / 8;
        int i2 = i - 11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i3 = 0;
        while (bArr.length > i3) {
            int iMin = Math.min(bArr.length - i3, i2);
            byte[] bArrEncodeBlock = encodeBlock(bArr, i3, iMin, bigInteger, bigInteger2, i);
            dataOutputStream.writeInt(bArrEncodeBlock.length);
            dataOutputStream.write(bArrEncodeBlock);
            i3 += iMin;
        }
        dataOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] encodeBlock(byte[] bArr, int i, int i2, BigInteger bigInteger, BigInteger bigInteger2, int i3) throws Throwable {
        if (bArr.length != i2 || i != 0) {
            byte[] bArr2 = new byte[i2];
            System.arraycopy(bArr, i, bArr2, 0, i2);
            bArr = bArr2;
        }
        BigInteger bigInteger3 = new BigInteger(paddingBlock(bArr, i3));
        if (bigInteger3.compareTo(bigInteger2) > 0) {
            throw new Throwable("the message must be smaller than the modulue");
        }
        return bigInteger3.modPow(bigInteger, bigInteger2).toByteArray();
    }

    private byte[] paddingBlock(byte[] bArr, int i) throws Throwable {
        if (bArr.length > i - 1) {
            throw new Throwable("Message too large");
        }
        byte[] bArr2 = new byte[i];
        bArr2[0] = 1;
        int length = bArr.length;
        bArr2[1] = (byte) (length >> 24);
        bArr2[2] = (byte) (length >> 16);
        bArr2[3] = (byte) (length >> 8);
        bArr2[4] = (byte) length;
        System.arraycopy(bArr, 0, bArr2, i - length, length);
        return bArr2;
    }

    public byte[] decode(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws IOException {
        DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (dataInputStream.available() > 0) {
            byte[] bArr2 = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr2);
            byteArrayOutputStream.write(decodeBlock(bArr2, bigInteger, bigInteger2));
        }
        dataInputStream.close();
        byteArrayOutputStream.close();
        return byteArrayOutputStream.toByteArray();
    }

    private byte[] decodeBlock(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        return recoveryPaddingBlock(new BigInteger(bArr).modPow(bigInteger, bigInteger2).toByteArray());
    }

    private byte[] recoveryPaddingBlock(byte[] bArr) throws Throwable {
        if (bArr[0] != 1) {
            throw new Throwable("Not RSA Block");
        }
        int i = ((bArr[1] & 255) << 24) + ((bArr[2] & 255) << 16) + ((bArr[3] & 255) << 8) + (bArr[4] & 255);
        byte[] bArr2 = new byte[i];
        System.arraycopy(bArr, bArr.length - i, bArr2, 0, i);
        return bArr2;
    }
}
