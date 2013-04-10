package com;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 */

/**
 * @author sankulka
 *
 */


public class AbstractDaoImpl {
	EntityManagerFactory emf;
	EntityManager em;
	
	public AbstractDaoImpl(){
		try{
			emf = Persistence.createEntityManagerFactory("WebLearning");
			em = emf.createEntityManager();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//em.close();
			//emf.close(); 
		}
	}
}
