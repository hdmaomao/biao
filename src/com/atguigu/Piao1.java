package com.atguigu;

public class Piao1 extends Thread {
	int qw = 30;

	public static void main(String[] args) {

		Piao1 p = new Piao1();
		p.start();

		Piao1 p1 = new Piao1();
		p1.start();

		Piao1 p2 = new Piao1();
		p2.start();

	}

	public void run() {
		synchronized (this) {
			this.notify();
			for (int i = 0; i < 30; i++) {
				System.out.println(Thread.currentThread().getName() + "余票："
						+ --qw);

			}

			try {
				this.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}
}
