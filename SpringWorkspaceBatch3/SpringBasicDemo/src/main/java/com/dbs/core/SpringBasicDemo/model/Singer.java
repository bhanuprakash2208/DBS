package com.dbs.core.SpringBasicDemo.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Singer {
	
	@Value("1")
	private String singerd;
	@Value("marshmellow")
	private String singername;
	@Autowired
	private Instrument instrument;
	
	public Singer() {
		System.out.println("Singer Constructor");
	}
	
	public String getSingerd() {
		return singerd;
	}
	public void setSingerd(String singerd) {
		this.singerd = singerd;
	}
	public String getSingername() {
		return singername;
	}
	public void setSingername(String singername) {
		this.singername = singername;
	}
	@Override
	public String toString() {
		return singername+" singing "+ "English song with "+getInstrument();
	}

	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}


}
