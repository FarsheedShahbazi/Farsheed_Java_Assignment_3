package objects;

public class User {
  private String name;
  private String email;
  private int phone;
  private String dayOfWeek; // select a day

  public User(String name, String email, int phone, String dayOfWeek) {
    this.name = name;
    this.email = email;
    this.phone = phone;
    this.dayOfWeek = dayOfWeek;
  } // constructor

  // ===============>>
  // GETTERS
  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public int getPhone() {
    return this.phone;
  }

  public String getDayOfWeek() { // addd day getter
    return this.dayOfWeek;
  }

  // ===============>>
  // SETTERS
  public void setName(String name) {
    this.name = name;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setPhone(int phone) {
    this.phone = phone;
  }

  public String setDayOfWeek(String dayOfWeek) { // add da setter
    return this.dayOfWeek = dayOfWeek;
  }
} // class