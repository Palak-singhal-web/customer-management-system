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
            menu = sc.nextInt();

            if(menu == 1)
                cs.addCustomer();
        }
    }
}