package com.dbs.jms;

import javax.jms.JMSContext;
import javax.jms.Queue;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;

public class Receiver {

	public static void main(String[] args) throws NamingException {
		// TODO Auto-generated method stub
		InitialContext ic = new InitialContext();
		Queue q = (Queue) ic.lookup("queue/myQueue");
		try (ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
				JMSContext jc = factory.createContext();
				
				){
			
			System.out.println(jc.createConsumer(q).receiveBody(String.class));
			
		}
	}

}
