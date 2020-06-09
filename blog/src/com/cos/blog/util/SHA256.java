package com.cos.blog.util;

import java.security.MessageDigest;

// 1234 -> 해쉬 ABCDJKEJKL

// 해쉬암호 : SHA256, HMAC256
// 암호화+복호화 : Base64

public class SHA256 {

	private final static String mSALT = "코스";

	public static String encodeSha256(String source) {
		String result = "";

		byte[] a = source.getBytes();
		byte[] salt = mSALT.getBytes();
		byte[] bytes = new byte[a.length + salt.length];

		System.arraycopy(a, 0, bytes, 0, a.length);
		System.arraycopy(salt, 0, bytes, a.length, salt.length);

		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(bytes);

			byte[] byteData = md.digest();

			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < byteData.length; i++) {
				sb.append(Integer.toString((byteData[i] & 0xFF) + 256, 16).substring(1));
			}

			result = sb.toString();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return result;
	}

}
