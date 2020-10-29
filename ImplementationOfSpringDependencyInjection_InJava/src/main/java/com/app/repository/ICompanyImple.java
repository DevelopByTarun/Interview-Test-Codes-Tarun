package com.app.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.app.bean.EmployeeBean;

@Repository(value = "companyRepository")
public class ICompanyImple implements ICompany {
	
	@Autowired
	private EmployeeBean employee;

	@Override
	public void getEmployee() {
		// TODO Auto-generated method stub
		System.out.println("Employee Id Is :: "+this.employee.getId());
		System.out.println("Employee Name Is :: "+this.employee.getName());
	}

	@Override
	public void getEmployeeWithAddress() {
		// TODO Auto-generated method stub
		System.out.println("Employee Id Is :: "+this.employee.getId());
		System.out.println("Employee Name Is :: "+this.employee.getName());
		System.out.println("Employee City Is :: "+this.employee.getAddressBean().getCity());
		System.out.println("Employee Pincode Is :: "+this.employee.getAddressBean().getPincode());
	}
}
