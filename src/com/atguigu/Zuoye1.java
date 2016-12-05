package com.atguigu;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Zuoye1 {
	public static void main(String[] args) {

	/*	Map map = new HashMap();
		map.put(1, "AA");
		map.put(1, "BB");
		System.out.println(map.get(1));
		System.out.println(map.get(1));
		*/
		
		final Res res = new Res();
		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 26; i++) {

					res.shuzi();
				}

			}
		}, "AA").start();

		new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 26; i++) {

					res.zimu();
				}

			}
		}, "BB").start();

	}


}

class Res {
	char a = 'A';
	int num = 0;
	int asd = 0;
	Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();

	public void shuzi() {

		try {
			lock.lock();
			while (asd != 0) {
				condition.await();
			}

			System.out.println(Thread.currentThread().getName() + "\t" + ++num);
			System.out.println(Thread.currentThread().getName() + "\t" + ++num);
			asd = 1;
			condition.signalAll();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();

		}

	}

	public void zimu() {
		try {
			lock.lock();
			while (asd != 1) {
				condition.await();
			}
		

			System.out.println(Thread.currentThread().getName() + "\t" + a++);

			asd = 0;
			condition.signalAll();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			lock.unlock();
		}

	}

}
