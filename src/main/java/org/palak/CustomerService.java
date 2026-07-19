package org.palak;

import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {
    ArrayList<Customer> customers = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void addCustomer(){
        System.out.println("Please enter customer ID");
        int custId = Integer.parseInt(sc.nextLine());
        for (Customer c : customers){
            if(custId == c.getCustomerId()){
                System.out.println("Customer ID already exists");
                return;
            }
        }

        System.out.println("Please enter customer name");
        String custName = sc.nextLine();
        if(custName.isEmpty()){
            System.out.println("Name cannot be empty. Please enter valid name");
            custName= sc.nextLine();
        }
        if(custName.isEmpty()){
            System.out.println("Customer addition failed");
            return;
        }

        System.out.println("Please enter customer email");
        String custEmail = sc.nextLine();
        while(!custEmail.matches("^[A-Za-z0-9_.-]+@[A-Za-z0-9]+\\.[A-Za-z]{2,3}$")){
            System.out.println("Please enter valid email");
            custEmail = sc.nextLine();
        }

        // TODO: Phone validation - char also allowed right now
        System.out.println("Please enter customer phone number");
        String custNo = sc.nextLine();
        while(custNo.isEmpty()){
            System.out.println("Please enter phone number");
            custNo = sc.nextLine();
        }

        Customer customer = new Customer();
        customer.setCustomerId(custId);
        customer.setName(custName);
        customer.setEmail(custEmail);
        customer.setPhoneNumber(custNo);
        customers.add(customer);
        System.out.println(customer);

    }

//    public Customer searchCustomer(int id){
//
//    }

}
