package com.app;

import java.util.Scanner;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

@SuppressWarnings("deprecation")
public class AppWithBeanFactory {
	
	public static void main( String[] args ) {
    	
//    	create bean factory for calling
		BeanFactory bf = new XmlBeanFactory(new FileSystemResource("spring_2.xml"));
    	IProducer produce = (IProducer) bf.getBean("producerObject_2");
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
    	while(true) {
    		System.out.println("1. Division Of Two Number");
    		System.out.println("2. Square Root");
    		System.out.println("3. Cube Root");
    		System.out.println("4. Exit");
    		System.out.print("Enter Your Choice :: ");
    		int choice = sc.nextInt();
    		if(choice == 1) {
    			System.out.print("Enter First Number :: ");
    			int num1 = sc.nextInt();
    			
    			System.out.print("Enter Second Number :: ");
    			int num2 = sc.nextInt();
    			
    			int result = produce.divide(num1, num2);
    			System.out.println("Division Of Two Number Is :: "+result);
    		}
    		else if(choice == 2) {
    			System.out.print("Enter Number :: ");
    			int num = sc.nextInt();
    			
    			int result = produce.squareRoot(num);
    			System.out.println("Square Root Of A Number Is :: "+result);
    		}
    		else if(choice == 3) {
    			System.out.print("Enter Number :: ");
    			int num = sc.nextInt();
    			
    			int result = produce.cubeRoot(num);
    			System.out.println("Cube Root Of A Number Is :: "+result);
    		}
    		else {
    			System.out.println("Good Byeee....");
    			return;
    		}
    	}
    }

}
