package com.deadlock;

/**
 * 
 * 死锁实例
 *
 */
public class DeadLockDemo implements Runnable {
	
	private boolean flag;
	
	public DeadLockDemo(boolean flag){
		this.flag = flag;
	}
	
	@Override
	public void run() {
		if(flag){
			synchronized(Locks.LOCK_A){
				System.out.println(Thread.currentThread().getName() + "lock.....a......if....");
				synchronized(Locks.LOCK_B){
					System.out.println(Thread.currentThread().getName() + "lock.....b......if....");
				}
			}
		}else{
			synchronized(Locks.LOCK_B){
				System.out.println(Thread.currentThread().getName() + "lock......b.....else....");
				synchronized(Locks.LOCK_A){
					System.out.println(Thread.currentThread().getName() + "lock......a.....else....");
					
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		DeadLockDemo task1 = new DeadLockDemo(true);
		DeadLockDemo task2 = new DeadLockDemo(false);
		Thread t1 = new Thread(task1);
		Thread t2 = new Thread(task2);
		t1.start();
		t2.start();
	}
	
	
	
}

class Locks {
	
	public static final Object LOCK_A = new Object();

	public static final Object LOCK_B = new Object();

}



