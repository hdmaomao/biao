package com.atguigu;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Douxiesou {

	public static void main(String[] args) throws InterruptedException {
		final Ref ref = new Ref();

		new Thread(new Runnable() {

			@Override
			public void run() {

				ref.set(new Random().nextInt(100));
			}
		}, "Aa").start();
		
		//Thread.sleep(1000);
		for (int i = 1; i < 100; i++) {

			new Thread(new Runnable() {

				@Override
				public void run() {
					ref.get();

				}
			}, String.valueOf(i)).start();
		}

	}

}

class Ref {

	Object obj;
	ReadWriteLock look = new ReentrantReadWriteLock();

	public void set(Object obj) {
		look.writeLock().lock();

		try {
			this.obj=obj;
			System.out.println(Thread.currentThread().getName() + "\t" + obj);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			look.writeLock().unlock();

		}

	}

	public void get() {

		look.readLock().lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t" + obj);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			look.readLock().lock();
		}

	}

}