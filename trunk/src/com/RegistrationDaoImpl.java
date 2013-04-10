package com;

import org.springframework.stereotype.Repository;

/**
 * 
 */

/**
 * @author sankulka
 *
 */

@Repository("RegistrationDao")
public class RegistrationDaoImpl extends AbstractDaoImpl implements RegistrationDao{

	@Override
	public boolean saveNewRegistration(User user) {
		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		return true;
	}

}
