package de.rieckpil.blog;

public class Customer {

  //made by me
  private Long id;
  private String firstName;
  private String lastName;

  public Customer() {
  }

  public Customer(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
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

public Long getId() {
    return id;
  }

  public void setId(String id) {
    this.id = Long.valueOf(id);
  }
}
