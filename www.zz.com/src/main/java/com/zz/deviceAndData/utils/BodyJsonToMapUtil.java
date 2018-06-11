package com.zz.deviceAndData.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;

public class BodyJsonToMapUtil {

	public static HashMap<String, Object> BodyJsonToMap(HttpServletRequest request) throws IOException {
		HashMap bodyMap=new HashMap();
		BufferedReader br = new BufferedReader(new InputStreamReader((ServletInputStream) request.getInputStream(), "utf-8"));
		StringBuffer sb = new StringBuffer("");
		String temp;
		while ((temp = br.readLine()) != null) {
		                sb.append(temp);
		                deal(temp);
		}
		br.close();
		String params = sb.toString();		
		System.out.println(params);		
		return null;
	}

	private static void deal(String temp) {
               	String[] split = temp.split(":");	
	}

	


 
}
