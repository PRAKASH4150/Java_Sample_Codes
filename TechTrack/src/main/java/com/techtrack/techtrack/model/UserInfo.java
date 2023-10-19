/**
 * UserInfo.java: This class acts as the POJO class
 * for the project. It contains the instance variables
 * to store the user data.
 *
 * @author Sai Surya Prakash Moka
 *
 * @date 10-18-2023
 */
package com.techtrack.techtrack.model;
public class UserInfo {
    private int userId;
    private String firstName;
    private String lastName;
    private int age;

    public  UserInfo(String firstName,String lastName,int age)
    {
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
    }

    public int getUserId()
    {
        return this.userId;
    }

    public void setFirstName(String firstName)
    {
        this.firstName=firstName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }
    public void setLastName(String lastName)
    {
        this.lastName=lastName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public void setAge(int age)
    {
        this.age=age;
    }
    public int getAge()
    {
        return this.age;
    }

    @Override
    public String toString()
    {
        return "\nUser Id:"+this.userId+
                "\nFirst Name:"+this.firstName+
                "\nLast Name:"+this.lastName+
                "\nAge:"+this.age;
    }
}
