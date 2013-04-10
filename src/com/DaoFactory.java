/**
 * 
 */
package com;

/**
 * @author sankulka
 *
 */
public class DaoFactory {
	public static RegistrationDao getRegistrationDao() {
		RegistrationDao registrationDao = new RegistrationDaoImpl();
        return registrationDao;
    }
}
