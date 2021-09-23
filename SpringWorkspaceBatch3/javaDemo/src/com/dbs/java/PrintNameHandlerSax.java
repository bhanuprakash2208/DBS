package com.dbs.java;

import java.util.Arrays;
import java.util.HashSet;

import java.util.Set;
import java.util.StringJoiner;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class PrintNameHandlerSax extends DefaultHandler {

	private StringBuilder currentValue = new StringBuilder();
	private Set<String> sdnNames = new HashSet<String>();
	//int lc=0,fc=0,cc=0;
	private String sdnFirstName = "";
	private	String sdnLastName = "";
	private String sdnCompleteName = "";
	private	String akaFirstName = "";
	private	String akaLastName = "";
	private	String akaCompleteName = "";
	private String[] arrOfStr;
	boolean akaEntry = false;

	public Set<String> getSdnNames() {
		return sdnNames;
	}

	@Override
	public void startDocument() {
		//System.out.println("Start Document");

	}

	@Override
	public void endDocument() {
		//  System.out.println("End Document");
		//System.out.println(sdnNames.size());  //36404

	}

	@Override
	public void startElement(
			String uri,
			String localName,
			String qName,
			Attributes attributes) {


		currentValue.setLength(0);
		if (qName.equalsIgnoreCase("sdnEntry")) { // 9124
			sdnFirstName = "";
			sdnLastName = "";
		}
		if (qName.equalsIgnoreCase("aka")) { // 14719
			akaEntry = true;
			akaFirstName = "";
			akaLastName = "";
		}


		//      System.out.printf("Start Element : %s%n", qName);


	}

	@Override
	public void endElement(String uri,
			String localName,
			String qName) {

		if (qName.equalsIgnoreCase("firstName")) {
			// System.out.printf("firstName : %s%n", currentValue.toString()+" "+(++fc)); // 11089
			if(akaEntry) {
				akaFirstName = currentValue.toString();
				sdnNames.add(formatString(akaFirstName));
				//System.out.println(formatString(akaFirstName));
			}
			else {
				sdnFirstName = currentValue.toString();
				sdnNames.add(formatString(sdnFirstName));
				//System.out.println(formatString(sdnFirstName));
			}
		}
		if (qName.equalsIgnoreCase("lastName")) {
			//System.out.printf("lastName : %s%n", currentValue.toString()+"*"+(++lc)); // 23843
			if(akaEntry) {
				akaLastName = currentValue.toString();
				sdnNames.add(formatString(akaLastName));
				//System.out.println(formatString(akaLastName));
			}
			else {
				sdnLastName = currentValue.toString();
				sdnNames.add(formatString(sdnLastName));
				//System.out.println(formatString(sdnLastName));
			}
		}

		if (qName.equalsIgnoreCase("sdnEntry")) {
			if(sdnFirstName!="" && sdnLastName!="") {
				sdnCompleteName = sdnFirstName + " " +sdnLastName;
				//cc++;
				//if(cc>=30)
				//System.exit(0);
				// common names 4698
				sdnNames.add(formatString(sdnCompleteName));
				//System.out.println(formatString(sdnCompleteName)+ cc);
				sdnFirstName="";
				sdnLastName="";
			}
		}
		if (qName.equalsIgnoreCase("aka")) {
			akaEntry = false;
			if(akaFirstName!="" && akaLastName!="") {
				akaCompleteName = akaFirstName + " " +akaLastName;
				//cc++;
				//if(cc==30)
				//System.exit(0);
				// common names 6391
				sdnNames.add(formatString(akaCompleteName));
				//System.out.println(formatString(akaCompleteName)+cc);
				akaFirstName="";
				akaLastName="";
			}

		}

	}

	// SAX parsers may return all contiguous character data in a single chunk,
	// or they may split it into several chunks
	@Override
	public void characters(char ch[], int start, int length) {

		currentValue.append(ch, start, length);

	}

	public String formatString(String name) { 
		arrOfStr = name.trim().toUpperCase().split(" ");
		Arrays.sort(arrOfStr);
		StringJoiner joiner = new StringJoiner(" ");
		for(int i = 0; i < arrOfStr.length; i++) {
			joiner.add(arrOfStr[i]);
		}
		return joiner.toString().trim();
	}
}

