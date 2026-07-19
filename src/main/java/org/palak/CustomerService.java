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

    public int deleteCustomer(int id){
        Customer customerToDelete = findCustomerById(id);
        if(customerToDelete != null) {
            customers.remove(customerToDelete);
            return 1;
        }
        return 0;
    }

    public Customer findCustomerById(int id){
        for(Customer c : customers){
            if(id == c.getCustomerId()) return c;
        }
        return null;
    }

}
