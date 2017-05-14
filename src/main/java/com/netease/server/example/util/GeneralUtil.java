package com.netease.server.example.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.UUID;

public class GeneralUtil {
	public static String generateId() {
		return UUID.randomUUID().toString().replaceAll("-", "");
	}

	public static String getPropery(String key, InputStream in) {
		Properties props = new Properties();
		try {
			props.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String value = props.getProperty(key);
		return value;
	}
}
