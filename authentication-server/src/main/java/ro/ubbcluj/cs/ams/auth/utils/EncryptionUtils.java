package ro.ubbcluj.cs.ams.auth.utils;


import org.apache.commons.codec.binary.Base64;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Utility class for loading certificates and keys.
 */
public final class EncryptionUtils {

    static final String PEM_RSA_PRIVATE_START = "-----BEGIN RSA PRIVATE KEY-----";
    static final String PEM_RSA_PRIVATE_END = "-----END RSA PRIVATE KEY-----";

    public static PrivateKey getPrivateKey(String privateKeyString) {
        KeyFactory kf;
        PrivateKey privateKey;
        PublicKey publicKey;
        try {
            kf = KeyFactory.getInstance("RSA");
            byte[] encodedPv = Base64.decodeBase64(privateKeyString);
            PKCS8EncodedKeySpec keySpecPv = new PKCS8EncodedKeySpec(encodedPv);
            privateKey = kf.generatePrivate(keySpecPv);

            byte[] encodedPb = Base64.decodeBase64(privateKeyString);
            X509EncodedKeySpec keySpecPb = new X509EncodedKeySpec(encodedPb);
            publicKey = kf.generatePublic(keySpecPb);
            return privateKey;

        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            return null;
        }
    }
}