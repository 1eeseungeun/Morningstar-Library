package model;

import java.text.DecimalFormat;

public class Pair <A, B, C> {
	private A first;
	private B second;
	private C third;
	
	public Pair(A first, B second, C third) {
		this.first = first;
		this.second = second;
		this.third = third;
	}
	
	public A getFirst() {
		return first;
	}
	
	public B getSecond() {
		return second;
	}
	
	public C getThird() {
		return third;
	}
	
	public void setFirst(A first) {
		this.first = first;
	}
	
	public void setSecond(B second) {
		this.second = second;
	}
	
	public void setThird(C third) {
		this.third = third;
	}
}
