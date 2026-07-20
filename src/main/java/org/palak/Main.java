package org.palak;
import java.util.Scanner;
public class Main {
    public static final Scanner sc = new Scanner(System.in);
    public static final CustomerService cs = new CustomerService();
    public static void main(String[] args) {
        int menu = 0;

        while(menu!=5) {
            System.out.println("Choose operation");
            System.out.println("1. Add Customer");
            System.out.println("2. Search Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Update Customer");
            System.out.println("5. Exit");
            menu = Integer.parseInt(sc.nextLine());

            switch (menu) {
                case 1:
                    addCustomer();
                    break;
                case 2:
                    searchCustomer();
                    break;
                case 3:
                    deleteCustomer();
                    break;
                case 4:
                    updateCustomer();
                    break;
                default:
                    System.out.println("Invalid input");
                    break;
            }
        }
    }

    public static String getValidName(){
        String name = sc.nextLine();
        while(name.isEmpty()){
            System.out.println("Name cannot be empty. Please enter valid name");
            name = sc.nextLine();
        }
        return name;
    }

    public static String getValidEmail(){
        String email = sc.nextLine();
        while(!email.matches("^[A-Za-z0-9_.-]+@[A-Za-z0-9]+\\.[A-Za-z]{2,3}$")){
            System.out.println("Please enter valid email");
            email = sc.nextLine();
        }
        return email;
    }

    public static String getValidPhoneNumber(){
        String phoneNumber = sc.nextLine();
        while(!phoneNumber.matches("^[7-9][0-9]{9}$")){
            System.out.println("Please enter valid phone number");
            phoneNumber = sc.nextLine();
        }
        return phoneNumber;
    }

    public static void addCustomer(){
        System.out.println("Please enter customer ID");
        int idToAdd = Integer.parseInt(sc.nextLine());
        if(cs.findCustomerById(idToAdd) != null){
            System.out.println("Customer ID " + idToAdd + " already exists.");
            return;
        }

        System.out.println("Please enter customer name");
        String custNameToAdd = getValidName();

        System.out.println("Please enter customer email");
        String custEmailToAdd = getValidEmail();

        System.out.println("Please enter customer phone number");
        String custNoToAdd = getValidPhoneNumber();

        cs.addCustomer(idToAdd, custNameToAdd, custEmailToAdd,custNoToAdd);
    }

    public static void searchCustomer(){
        System.out.println("Enter customer ID you want to search");
        int idToSearch = Integer.parseInt(sc.nextLine());
        Customer customer = cs.searchCustomer(idToSearch);
        if (customer == null) {
            System.out.println("Customer not found");
        } else {
            System.out.println(customer);
        }
    }

    public static void deleteCustomer(){
        System.out.println("Enter customer ID you want to delete");
        int idToDelete = Integer.parseInt(sc.nextLine());
        Customer customer = cs.findCustomerById(idToDelete);
        if (customer == null)
            System.out.println("Customer ID is invalid");
        else {
            cs.deleteCustomer(customer);
            System.out.println("Customer ID " + idToDelete + " successfully deleted");
        }
    }

    public static void updateCustomer(){
        System.out.println("Enter customer ID you want to update");
        int idToUpdate = Integer.parseInt(sc.nextLine());
        if (cs.findCustomerById(idToUpdate) == null) {
            System.out.println("Customer ID " + idToUpdate + " does not exists.");
            return;
        }
        boolean flag = true;
        while (flag) {
            System.out.println("What do you want to update?");
            System.out.println("1- Name\n2- Email\n3- Phone Number\n4- End");
            int updateMenu = Integer.parseInt(sc.nextLine());

            switch (updateMenu) {
                case 1:
                    System.out.println("Please enter new name");
                    String custNameToUpdate = getValidName();
                    cs.updateCustomer(idToUpdate, updateMenu, custNameToUpdate);
                    break;
                case 2:
                    System.out.println("Please enter new email");
                    String custEmailToUpdate = getValidEmail();
                    cs.updateCustomer(idToUpdate, updateMenu, custEmailToUpdate);
                    break;
                case 3:
                    System.out.println("Please enter new phone number");
                    String custNoToUpdate = getValidPhoneNumber();
                    cs.updateCustomer(idToUpdate, updateMenu, custNoToUpdate);
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