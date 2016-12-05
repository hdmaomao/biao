package com.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Piao3 {
	public static void main(String[] args) {

		final Red red = new Red();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					
					red.add();
				}

			}
		}, "AA").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 20; i++) {
					
					red.delect();
				}

			}
		}, "BB").start();

	}

}

class Red {
	int num = 0;
	int number = 0;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void add() {
		try {
			lock.lock();
			while (num != 0) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() + "\t"
					+ ++number);
			num = 1;
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			lock.unlock();

		}
	}

	public void delect() {

		try {
			lock.lock();
			while (num != 1) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName() + "\t"
					+ --number);
			num = 0;
			condition.signal();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();

		}

	}

}