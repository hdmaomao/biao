package com.atguigu;

import javax.imageio.spi.ServiceRegistry.Filter;

public class piao2 implements Runnable{

  static int num = 0;
static  Piao3 p1 = new Piao3();
static  piao2 p = new piao2();
	
	public static void main(String[] args) {
	
		new Thread(p).start();
			
			
		}

	@Override
	public void run() {
		
		for (int i = 0; i < 1000; i++) {
			System.out.println(Thread.currentThread().getName()+"|"+ ++num);
			System.out.println();
		}
	
		
	}
		
	
	
	}
	



