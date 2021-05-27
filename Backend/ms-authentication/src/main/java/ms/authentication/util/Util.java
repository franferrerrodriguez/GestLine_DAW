package ms.authentication.util;

import java.security.SecureRandom;

import ms.authentication.entity.db.User;

public class Util {
	
	public static final String CHARACTERS = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";


	public static final int SECURE_TOKEN_LENGTH = 256;

	private static final SecureRandom random = new SecureRandom();

	private static final char[] symbols = CHARACTERS.toCharArray();

	private static final char[] buf = new char[SECURE_TOKEN_LENGTH];
	
	public static User setUserToken(User user) {
		if(user != null)
			user.setToken(newToken());
		return user;
	}
	
	public static String newToken() {
	    for (int idx = 0; idx < buf.length; ++idx)
	        buf[idx] = symbols[random.nextInt(symbols.length)];
	    return new String(buf);
	}

}