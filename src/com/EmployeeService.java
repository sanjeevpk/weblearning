
package com;

import java.util.List;

public interface EmployeeService {

	/**
	 * @param i
	 * @param recordsPerPage
	 * @return
	 */
	List<Employee> viewAllEmployees(int i, int recordsPerPage);

	/**
	 * @return
	 */
	int getNoOfRecords();

}
