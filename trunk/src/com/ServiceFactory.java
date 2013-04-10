/**
 * 
 */
package com;

/**
 * @author sankulka
 *
 */
public class ServiceFactory {
	
	public static RegistrationService getRegistrationService() {
		RegistrationService registrationService = new RegistrationServiceImpl();
        return registrationService;
    }
}
