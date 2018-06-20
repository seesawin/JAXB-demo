package tw.com.seesawin.util;

import java.io.InputStream;

public class FileReader {
	/*
	 * read file
	 * 
	 * */
	public static InputStream getFileWithUtil(Class clazz, String fileName) {
		ClassLoader classLoader = clazz.getClassLoader();
		return classLoader.getResourceAsStream(fileName);
	}
}
