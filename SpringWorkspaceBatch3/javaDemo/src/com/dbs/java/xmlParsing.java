package com.dbs.java;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class xmlParsing {

	public static void main(String args[]) {
		int  c =0;
		try {

			File inputFile = new File("sdn.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("sdnEntry");
			System.out.println(nList.getLength()); //9124 
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);//if(c>=20)break;
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					NodeList details = nNode.getChildNodes();
					
					//working and getting 9124 lastNames
					//System.out.println(eElement.getElementsByTagName("lastName").item(0).getTextContent()+" count "+c);

//					System.out.println(details.getLength());
//					for(int j=0;j<details.getLength();j++) {
//						Node detail = details.item(j);
//
//						if (detail.getNodeType() == Node.ELEMENT_NODE) {
//							Element detaileElement = (Element) detail;
							++c;

							//System.out.println(detaileElement.getTagName()+" "+c);
							//	System.out.println(detaileElement.getElementsByTagName("uid").item(0));
							//							
						}
					}				

				
			
		}


		catch(Exception e) {
			System.out.println("In exception");
			e.printStackTrace();

		}
	}
}
