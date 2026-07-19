package org.palak;

public class Customer {
    int customerId;
    String name;
    String email;
    String phoneNumber;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "  Customer Details \n-------------------- \n" +
                "customerId  : " + customerId +
                "\nname        : " + name +
                "\nemail       : " + email +
                "\nphoneNumber : " + phoneNumber;
    }
}
