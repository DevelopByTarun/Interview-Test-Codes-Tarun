package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import com.app.bean.AddressBean;
import com.app.bean.EmployeeBean;
import com.app.repository.ICompany;
import com.app.repository.ICompanyImple;

public class AppConfig {
	
	// constructor injection
	@Bean
	@Scope("singleton")
	AddressBean getAddressBean() {
		AddressBean ab = new AddressBean("Sydney", 8567766);
		return ab;
	}
	
	// setter injection
	@Bean
	@Lazy
	EmployeeBean getEmployeeBean() {
		EmployeeBean eb = new EmployeeBean();
		eb.setId(1002);
		eb.setName("Varun");
		return eb;
	}
	
	// getter injection
	@Bean(name = "icomp")
	ICompany getICompany() {
		return new ICompanyImple();
	}
}
