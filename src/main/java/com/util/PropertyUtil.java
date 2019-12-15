package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @ClassName:PropertyUtil.java     
 * @version V1.0 
 * @author: http://www.wgstart.com     
 * @date: 2019年1月14日
 * @Description: PropertyUtil.java
 * @Copyright: 2019 wgcloud. All rights reserved.
 *
 */
public class PropertyUtil {
	
	public static Set<String> getKeys(String fileName){
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream in = classLoader.getResourceAsStream(fileName); 
		Properties p = new Properties();
		Set<String> keySet = null;
		try {
			p.load(in);
			keySet = p.stringPropertyNames();
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return keySet;
	}
	
	
	public static String get(String fileName,String propertyName) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		InputStream in = classLoader.getResourceAsStream(fileName);
		Properties p = new Properties();
		String msg = "";
		try {
			p.load(in);
			msg = (String)p.get(propertyName);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}  
		return msg;
	}
	
	
}
