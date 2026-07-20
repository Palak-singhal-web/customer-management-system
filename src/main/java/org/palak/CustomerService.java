package org.palak;
import java.util.ArrayList;

public class CustomerService {
    ArrayList<Customer> customers = new ArrayList<>();

    public void addCustomer(int id, String name, String email, String phoneNo){
        Customer customer = new Customer(id, name,email, phoneNo);
        customers.add(customer);
    }

    public Customer searchCustomer(int id){
        return findCustomerById(id);
    }

    public void deleteCustomer(Customer customerToDelete){
        customers.remove(customerToDelete);
    }

    public void updateCustomer( int id, int field, String value){
        Customer customer = findCustomerById(id);
        switch(field){
            case 1:
                customer.setName(value);
                break;
            case 2:
                customer.setEmail(value);
                break;
            case 3:
                customer.setPhoneNumber(value);
                break;
        }
    }

    public Customer findCustomerById(int id){
        for(Customer c : customers){
            if(id == c.getCustomerId()) return c;
        }
        return null;
    }

}
