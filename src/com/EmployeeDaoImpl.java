package com;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 * @author sankulka
 *
 */

@Repository("EmployeeDao")
public class EmployeeDaoImpl extends AbstractDaoImpl implements EmployeeDao {
	private static int size = 0;

	/* (non-Javadoc)
	 * @see com.EmployeeDao#viewAllEmployees(int, int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> viewAllEmployees(int i, int recordsPerPage) {
		String sql = "select x from Employee x";

		Query query = em.createQuery(sql);
		query.setFirstResult(i);
		query.setMaxResults(recordsPerPage);
		size = query.getResultList().size();
		System.out.println("asas-->>"+size);
		
		return (List<Employee>) query.getResultList();
	}

	/* (non-Javadoc)
	 * @see com.EmployeeDao#getNoOfRecords()
	 */
	@Override
	public int getNoOfRecords() {
		Query query = em.createQuery("select x from Employee x");
		System.out.println("Max -->>"+query.getResultList().size());
		return query.getResultList().size();
	}

}
