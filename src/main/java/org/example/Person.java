package org.example;

public class Person {
    private int id;
    private String firstName;
    private String lastName;
    private String email;

    public Person(int id, String firstName, String lastName, String email) {
        this.id = id;
        setFirstName(firstName);
        setLastName(lastName);
        setEmail(email);
    }

    public int getId() {
        return id;
    }

    public String getFirstName()
    {  return firstName;
    }

    public void setFirstName(String firstName) {
        if(firstName == null ||firstName.trim().isEmpty())
            throw new IllegalArgumentException("first name can not be null");
        this.firstName = firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setLastName(String lastName) {
        if(lastName == null) {
            throw new IllegalArgumentException("last name can not be null");
        }
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email == null)
            throw new IllegalArgumentException("email should not be null");
        this.email = email;
    }

    public String getSummary(){
       return "{id:" +id+ " Name:" +firstName+lastName+ " email:" +email+"}";
    }

    }