package com.atguigu;

import java.util.Random;

public class Jvm {
public static void main(String[] args) {
//	long maxMemory = Runtime.getRuntime().maxMemory() ;//返回 Java 虚拟机试图使用的最大内存量。
//	long totalMemory = Runtime.getRuntime().totalMemory() ;//返回 Java 虚拟机中的内存总量。
//	System.out.println("TOTAL_MEMORY = " + totalMemory + "（字节）、" + (totalMemory / (double)1024 / 1024) + "MB");
//	System.out.println("MAX_MEMORY = " + maxMemory + "（字节）、" + (maxMemory / (double)1024 / 1024) + "MB");
//	String str = "www.atguigu.com" ;
//	while(true) 
//	{
//	str += str + new Random().nextInt(88888888) + new Random().nextInt(999999999) ;
//	
//	}

	int[] arr = new  int[]{1,5,15,65,-64,45,98,12};
	for (int i = 0; i < arr.length-1; i++) {
		//System.out.println(arr[i]);
		for (int j = 0; j < arr.length-1-i; j++) {
			if (arr[j]<arr[j+1]) {
			int temp = arr[j];
				arr[j] =arr[j+1];
				arr[j+1]=temp;
				
			}
		}
	}
	for (int i : arr) {
		System.out.println(i);
		System.out.println("1111");
		System.out.println("221");
	}
	}
	
	
}

