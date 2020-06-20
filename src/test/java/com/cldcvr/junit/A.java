package com.cldcvr.junit;

import java.util.HashMap;
import java.util.Map;

public class A {
	public static void main(String args[]) {
		String str = "aabbbccccDDeeerrrksksdkfskj";
		Map<String,Integer> map = new HashMap<String,Integer>();
		for(int i =  0; i<str.length()-1;i++) {
			if(map.containsKey(str.charAt(i)+"")) {
				int k =0;
				map.put(str.charAt(i)+"",map.get(str.charAt(i)+"")+1);
			}else {
				map.put(str.charAt(i)+"",1);
				
			}
		}
		System.out.println(map);
	}
}