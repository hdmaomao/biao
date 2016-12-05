package com.atguigu;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Zouye2 {

	public static void main(String[] args) {
		final Rea rea = new Rea();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					rea.A();
				}

			}
		}, "A").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					rea.B();
				}

			}
		}, "B").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					rea.C();
				}

			}
		}, "C").start();

	}

}

class Rea {
	int num = 0;

	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void A() {

		try {
			lock.lock();
			while (num != 0) {
				condition.await();
			}

			System.out.println(Thread.currentThread().getName());

			num = 1;
			condition.signalAll();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

	public void B() {

		try {
			lock.lock();
			while (num != 1) {
				condition.await();

			}
			System.out.println(Thread.currentThread().getName());
			num = 2;
			condition.signalAll();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			lock.unlock();

		}

	}

	public void C() {
		try {
			lock.lock();
			while (num != 2) {
				condition.await();
			}
			System.out.println(Thread.currentThread().getName());
			num = 0;
			condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}

	}

}