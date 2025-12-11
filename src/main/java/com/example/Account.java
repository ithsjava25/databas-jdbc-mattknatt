package com.example;

public class Account {
    private int userId;
    private String name, password, firstName, lastName, ssn;

    public Account(int userId, String name, String password, String firstName, String lastName, String ssn) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public Account(String name, String password, String firstName, String lastName, String ssn) {
        this.name = name;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.ssn = ssn;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    @Override
    public String toString() {
        return "Account{" +
                "user_id=" + userId +
                ", name='" + name + '\'' +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", ssn='***'" +
                '}';
    }
}
