package com.company;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.*;
import java.util.LinkedList;
import java.util.List;

public class Main {


    public static void main(String[] args) throws NoSuchAlgorithmException,
            NoSuchPaddingException,
            InvalidKeyException,
            IllegalBlockSizeException,
            BadPaddingException {

        String text =
                "Торт\n";

        Cipher cipher = Cipher.getInstance( "RSA" );
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance( "RSA" );
        keyGen.initialize( 512 );
        KeyPair kp = keyGen.genKeyPair();

        System.out.println("\nText is:\n" + keyGen);
        System.out.println("  Пара " + kp);

        PublicKey publicKey = kp.getPublic();
        PrivateKey privateKey = kp.getPrivate();

        System.out.println("\nПубличный:\n" +publicKey);
        System.out.println("\nЗакрытый\n" + privateKey);

        cipher.init( Cipher.ENCRYPT_MODE, publicKey );
        byte[] x = cipher.doFinal( text.getBytes() );

        cipher.init( Cipher.DECRYPT_MODE, privateKey );
        byte[] y = cipher.doFinal( x );

        System.out.println("\nText is:\n" + text);
        System.out.println("\nEncrypt text:\n" + new String (x));
        System.out.println("\nDecrypt text:\n" + new String (y));
    }
}
