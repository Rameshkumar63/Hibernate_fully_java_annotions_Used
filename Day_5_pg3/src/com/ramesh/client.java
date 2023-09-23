package com.ramesh;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class client {
public static void main(String[] args) {
	Transaction txs = null;

	try {
		// 1 get the sessionfactory
		SessionFactory sf = hibernateUtil.getSessionFactory();
		
		// open the session
		Session session = sf.openSession();
		
		// 3  Begin the transaction();
		txs = session.beginTransaction();
		
		//4 perform opreation
		Customer cust = new Customer("ramesh","rame@gmail.com",6565,"gonda");
		session.save(cust);
		
		// step 5 
		txs.commit();
		session.close();
	}catch(Exception e) {
		// 
		txs.rollback();
		e.printStackTrace();
	}
}
}
