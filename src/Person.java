public class Person {

    //Declare attributes to the person class
    private String name;
    private String surname;
    private String Email;

    //Define a constructor for the Person class
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.Email = email;
    }

    //Define getters for attributes
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return Email;
    }
}
