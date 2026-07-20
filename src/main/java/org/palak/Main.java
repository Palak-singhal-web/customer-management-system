package org.palak;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        CustomerService cs = new CustomerService();
        Scanner sc = new Scanner(System.in);
        int menu = 0;

        while(menu!=5) {
            System.out.println("Choose operation");
            System.out.println("1. Add Customer");
            System.out.println("2. Search Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Exit");
            menu = Integer.parseInt(sc.nextLine());

            if(menu == 1) {
                System.out.println("Please enter customer ID");
                int idToAdd = Integer.parseInt(sc.nextLine());
                if(cs.findCustomerById(idToAdd) != null){
                    System.out.println("Customer ID " + idToAdd + " already exists.");
                    continue;
                }

                System.out.println("Please enter customer name");
                String custNameToAdd = sc.nextLine();
                if(custNameToAdd.isEmpty()){
                    System.out.println("Name cannot be empty. Please enter valid name");
                    custNameToAdd= sc.nextLine();
                }
                if(custNameToAdd.isEmpty()){
                    System.out.println("Customer addition failed");
                    return;
                }

                System.out.println("Please enter customer email");
                String custEmailToAdd = sc.nextLine();
                while(!custEmailToAdd.matches("^[A-Za-z0-9_.-]+@[A-Za-z0-9]+\\.[A-Za-z]{2,3}$")){
                    System.out.println("Please enter valid email");
                    custEmailToAdd = sc.nextLine();
                }

                // TODO: Phone validation - char also allowed right now
                System.out.println("Please enter customer phone number");
                String custNoToAdd = sc.nextLine();
                while(custNoToAdd.isEmpty()){
                    System.out.println("Please enter phone number");
                    custNoToAdd = sc.nextLine();
                }
                cs.addCustomer(idToAdd, custNameToAdd, custEmailToAdd,custNoToAdd);
            }
            if(menu == 2) {
                System.out.println("Enter customer ID you want to search");
                int idToSearch = Integer.parseInt(sc.nextLine());
                Customer customer = cs.searchCustomer(idToSearch);
                if(customer == null){
                    System.out.println("Customer not found");
                }else{
                    System.out.println(customer);
                }
            }
            if(menu == 3){
                System.out.println("Enter customer ID you want to delete");
                int idToDelete = Integer.parseInt(sc.nextLine());
                if(cs.deleteCustomer(idToDelete) == 0)
                    System.out.println("Customer ID is invalid");
                else
                    System.out.println("Customer ID " + idToDelete + " successfully deleted");
            }
            if(menu ==4){
                System.out.println("Enter customer ID you want to update");
                int idToUpdate = Integer.parseInt(sc.nextLine());
                if(cs.findCustomerById(idToUpdate) == null){
                    System.out.println("Customer ID " + idToUpdate + " does not exists.");
                    continue;
                }
                boolean flag = true;
                while(flag){
                    System.out.println("What do you want to update?");
                    System.out.println("1- Name\n2- Email\n3- Phone Number\n4- End");
                    int updateMenu = Integer.parseInt(sc.nextLine());

                    switch(updateMenu){
                        case 1:
                            System.out.println("Please enter new name");
                            String custNameToUpdate = sc.nextLine();
                            if(custNameToUpdate.isEmpty()){
                                System.out.println("Name cannot be empty. Please enter valid name");
                                custNameToUpdate= sc.nextLine();
                            }
                            if(custNameToUpdate.isEmpty()){
                                System.out.println("Customer addition failed");
                                return;
                            }
                            cs.updateCustomer(idToUpdate, updateMenu, custNameToUpdate);
                            break;
                        case 2:
                            System.out.println("Please enter new email");
                            String custEmailToUpdate = sc.nextLine();
                            while(!custEmailToUpdate.matches("^[A-Za-z0-9_.-]+@[A-Za-z0-9]+\\.[A-Za-z]{2,3}$")){
                                System.out.println("Please enter valid email");
                                custEmailToUpdate = sc.nextLine();
                            }
                            cs.updateCustomer(idToUpdate,updateMenu,custEmailToUpdate);
                            break;
                        case 3:
                            System.out.println("Please enter new phone number");
                            String custNoToUpdate = sc.nextLine();
                            while(custNoToUpdate.isEmpty()){
                                System.out.println("Please enter phone number");
                                custNoToUpdate = sc.nextLine();
                            }
                            cs.updateCustomer(idToUpdate,updateMenu,custNoToUpdate);
                            break;
                        case 4:
                            System.out.println("Thank you!");
                            flag = false;
                            break;
                        default:
                            System.out.println("Invalid Input");
                    }
                }
            }
        }
    }
}