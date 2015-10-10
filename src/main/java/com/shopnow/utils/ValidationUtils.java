package com.shopnow.utils;

import java.util.Collections;

public class ValidationUtils {
	public static Iterable nullSafe( Iterable other ) {
	    return other == null ? Collections.EMPTY_LIST : other;
	}
}
