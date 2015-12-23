package com.shopnow.utils;

import java.util.Collections;

public class ValidationUtils<T> {
	/**
	 * This method checks whether an Iterable<T> iterable is null or not, If it finds it as null simply change it to empty
	 * @param iterable
	 * @return
	 */
	public static <T> Iterable<T> nullSafe(Iterable<T> iterable) {
	    return iterable == null ? Collections.<T>emptyList() : iterable;
	}
}
