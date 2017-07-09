package com.java.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.java.dao.EmployeeDAO;
import com.java.model.Employee;

public class EmployeeDAOimpl implements EmployeeDAO {

	private HibernateTemplate hibernateTemplate;

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	@Override
	public void createEmployee(Employee employee) {
		hibernateTemplate.save(employee);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee getEmployeeById(int empid) {
		Employee employee = hibernateTemplate.get(Employee.class, empid);
		return employee;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void deleteEmployeeById(int empid) {
		Employee employee = new Employee();
		employee.setEmpid(empid);
		hibernateTemplate.delete(employee);
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public void updateEmployeeEmailById(String newemail, int empid) {
		Employee employee = hibernateTemplate.get(Employee.class, empid); 
		employee.setEmail(newemail);
		hibernateTemplate.update(employee);
 
	}

	@Override
	public List<Employee> getAllEmployeeDetails() {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> EmpList = (List<Employee>) hibernateTemplate.findByCriteria(criteria);
		return EmpList;
	}
}