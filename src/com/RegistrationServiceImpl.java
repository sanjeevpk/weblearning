package com;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 
 */

/**
 * @author sankulka
 *
 */

@Service
public class RegistrationServiceImpl implements RegistrationService{
	
	@Autowired
	RegistrationDao registrationDao;

	@Override
	public boolean saveNewRegistration(User user) {
		boolean saved = DaoFactory.getRegistrationDao().saveNewRegistration(user);//registrationDao.saveNewRegistration(user);
		if(saved){
			return true;
		}else{
			return false;
		}
	}

}
