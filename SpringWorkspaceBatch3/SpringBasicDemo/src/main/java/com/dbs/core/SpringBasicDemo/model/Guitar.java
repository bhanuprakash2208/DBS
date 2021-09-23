package com.dbs.core.SpringBasicDemo.model;

import org.springframework.stereotype.Component;

@Component
public class Guitar implements Instrument {
	
	public Guitar() {
		System.out.println("Guitar class created");
	}
	
	@Override
	public String toString() {
		return "Guitar";
	}

	public void play() {
		System.out.println("Playing guitar");
	}

}
