package com.single;

/**
 *线程安全高效单例模式，懒汉式 
 *
 *加锁是为了解决线程问题，多加一步判断是为了解决效率问题
 */
public class Single {

	private Single(){}
	private static Single single = null;
	
	public static Single getInstance(){
		if(single == null){
			synchronized(Single.class){
				if(single == null){
					single = new Single();
				}
			}
		}
		return single;
	}
	
}
