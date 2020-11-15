package kr.or.bit.utils;

import java.security.MessageDigest;


/**
 * @author user
 */

public class c_SHAUtil {


    public String getSha512(String msg) {

        String result = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-512");
            digest.reset();
            digest.update(msg.getBytes("UTF-8"));
            // byte[]
            result = String.format("%0128x", new java.math.BigInteger(1, digest.digest()));
        } catch (Exception e) {
            result = "";
            e.printStackTrace();
        }
        return result;
    }

}