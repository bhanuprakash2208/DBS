package com.dbs.java;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;

public class XmlParsingWithSAX {


    public static void main(String[] args) {
    	
    	final String FILENAME = "sdn.xml";
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try {
        	Scanner sc = new Scanner(System.in);
        	
        	
            SAXParser saxParser = factory.newSAXParser();

            PrintNameHandlerSax handler = new PrintNameHandlerSax();
            saxParser.parse(FILENAME, handler);
            Set<String> sdnNames = handler.getSdnNames();
            
            System.out.println(sdnNames.size());
            System.out.println("Enter Name:");
            String name = sc.nextLine();
            name = handler.formatString(name);
            if(sdnNames.contains(name))
            	System.out.println("Found");
            else
            	System.out.println("Not Found");

        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
        	e.printStackTrace();
        }
        
        

    }

}
