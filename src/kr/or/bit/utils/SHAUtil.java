package kr.or.bit.utils;

import java.security.MessageDigest;


/**
<<<<<<< HEAD
 * ?΄?±?κ³ λ¦¬μ¦μ ?¬?©?΄? ??Έ??? ?΄??€
=======
 * 
>>>>>>> f6fa83a0eea4f294321c96fd8368998a4f885e8f
 * @author user
 *
 */

public class SHAUtil {
	
	
	
		

	public String getSha512(String msg) {

		String result = null;
		try {
		    MessageDigest digest = MessageDigest.getInstance("SHA-512");
		    digest.reset();
		    digest.update( msg.getBytes("UTF-8"));
<<<<<<< HEAD
            // byte[]  λ₯? λ¬Έμ?΄λ‘? λ³???? λΆ?λΆ?
=======
            // byte[] 
>>>>>>> f6fa83a0eea4f294321c96fd8368998a4f885e8f
		    result = String.format("%0128x", new java.math.BigInteger(1, digest.digest()));
		} catch (Exception e) {
			result ="";
		    e.printStackTrace();
		}
		return result;
	}
}
