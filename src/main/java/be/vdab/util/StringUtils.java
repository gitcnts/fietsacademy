package be.vdab.util;

import java.math.BigDecimal;

public class StringUtils {
	
	public static boolean isLong(String string) {
		if (string == null) {
			return false;
		}
		try {
			Long.parseLong(string);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
	public static boolean isBigDecimal(String string) {
		if (string == null) {
			return false;
		}
		try {
			new BigDecimal(string);
			return true;
		} catch (NumberFormatException ex) {
			return false;
		}
	}
	
}
