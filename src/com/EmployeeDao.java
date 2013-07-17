package com;

import java.util.List;

/**
 * @author sankulka
 *
 */
public interface EmployeeDao {

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
