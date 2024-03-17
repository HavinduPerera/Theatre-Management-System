public class Ticket {

    //Declare attributes to the ticket class
    private int row;
    private int seat;
    public double price;
    private Person person;

    //Define a constructor for the Ticket class
    public Ticket(int row, int seat, double price, Person person) {
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }

    //Define getters for attributes
    public int getRow() {
        return row;
    }

    public int getSeat() {
        return seat;
    }

    public double getPrice() {
        return price;
    }

    //Declaring the print method
    public void print(){
        System.out.println("Person Name : "+person.getName());
        System.out.println("Person Surname : "+person.getSurname());
        System.out.println("Person Email : "+person.getEmail());
        System.out.println("Row : "+row);
        System.out.println("Seat : "+seat);
        System.out.println("Price : "+price);
    }

}
