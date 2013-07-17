
package com;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * @author sankulka
 *
 */

@Service
public class EmployeeServiceImpl implements EmployeeService{

	/* (non-Javadoc)
	 * @see com.EmployeeService#viewAllEmployees(int, int)
	 */
	@Override
	public List<Employee> viewAllEmployees(int i, int recordsPerPage) {
		List<Employee> empList = DaoFactory.getEmployeeDao().viewAllEmployees(i,recordsPerPage);
		return empList;
	}

	/* (non-Javadoc)
	 * @see com.EmployeeService#getNoOfRecords()
	 */
	@Override
	public int getNoOfRecords() {
		int number = DaoFactory.getEmployeeDao().getNoOfRecords();
		return number;
	}

}
