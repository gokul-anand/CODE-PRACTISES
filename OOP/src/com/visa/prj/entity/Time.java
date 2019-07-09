package com.visa.prj.entity;

public class Time {
	
	private int hrs;
	private int mins;
	
	public Time(int hrs, int mins){
		this.hrs = hrs;
		this.mins = mins;
	}
	
	public static Time add( Time t1, Time t2) {
		int hrs = t1.hrs + t2.hrs;
		int mins = t1.mins + t2.mins;
		
		if (mins>=60) {
			hrs += 1;
			mins -= 60;
		}
		
		return new Time(hrs,mins);
	}
	
	public Time add(Time t2) {
		return  Time.add(this,t2);	
	}

}
