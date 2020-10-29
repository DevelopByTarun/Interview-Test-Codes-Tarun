package com.app;

import com.app.repository.ICompany;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App 
{
    public static void main( String[] args ) {

        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ICompany company = (ICompany) context.getBean("icomp");
        System.out.println("Employee Details Is Given Below :->");
        company.getEmployee();
        System.out.println("");
        System.out.println("Employee Details With Address Is Given Below :->");
        company.getEmployeeWithAddress();
    }

}
