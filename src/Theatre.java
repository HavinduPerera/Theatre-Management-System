//I declare that my work contains no examples of misconduct, such as plagiarism, or collusion.
//Any code taken from other sources is referenced within my code solution.
//Student ID : w1953252
//Date : 20/03/2023

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Theatre {
    //Define 3 arrays for each row
    private static int[] row1 = new int[12];
    private static int[] row2 = new int[16];
    private static int[] row3 = new int[20];

    //An ArrayList to store the booked tickets
    private  static ArrayList<Ticket> tickets = new ArrayList<Ticket>();

    //Main method
    public static void main(String[] args) {

        //printing the welcome note
        System.out.println("Welcome to the New Theatre");

        //To make it separate section
        label:
        while (true){
            //printing the menu
            System.out.println("""
                    -------------------------------------------------
                    Please select an option : 
                    1) Buy a ticket
                    2) Print seating area
                    3) Cancel ticket
                    4) List available seats
                    5) Save to file
                    6) Load from file
                    7) Print ticket information and total price
                    8) Sort tickets by price
                        0) Quit
                    -------------------------------------------------
                    """);


            Scanner input = new Scanner(System.in);


            System.out.println("Enter option : ");
            try {
                int option = input.nextInt();
                //Define switch cases for the conditional statements
                switch (option) {
                    case 1:
                        buy_ticket();
                        break;
                    case 2:
                        print_seating_area();
                        break;
                    case 3:
                        cancel_ticket();
                        break;
                    case 4:
                        show_available();
                        break;
                    case 5:
                        save();
                        break;
                    case 6:
                        load();
                        break;
                    case 7:
                        show_tickets_info();
                        break;
                    case 8:
                        sort_tickets();
                        break;
                    case 0:
                        System.out.println("Thank you");
                        break label;        //To quite from the program
                    default:
                        System.out.println("Please enter a valid input.");
                        break;
                }
            }catch (Exception e){
                System.out.println("Invalid option.");
                input.nextLine();
            }


        }
    }

    //buy_ticket method
    public static void buy_ticket(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the row no. : ");     //allows the user to enter the row number
        int buy_row = input.nextInt();

        if (buy_row == 1){
            for(int i = 0 ; i < row1.length ; i++){
                System.out.println("Enter the seat no. : ");    //allows the user to enter the seat number
                int seat = input.nextInt();
                if (seat < row1.length+1) {
                    if (row1[seat - 1] == 1) {
                        System.out.println("Sorry! Already reserved");
                    } else {
                        row1[seat - 1] = 1;   //update the row1 array
                        add_details(buy_row, seat);     //add ticket info for the array list
                        System.out.println("Your reservation has completed successfully.");
                    }
                }else {
                    System.out.println("Invalid seat.");
                }
                break;
            }
        }else if (buy_row == 2){
            for (int i = 0 ; i < row2.length ; i++){
                System.out.println("Enter the seat no. : ");
                int seat = input.nextInt();
                if (seat < row2.length+1) {
                    if (row2[seat - 1] == 1) {
                        System.out.println("Sorry! Already reserved");
                    } else {
                        row2[seat - 1] = 1;     //update the row2 array
                        add_details(buy_row, seat);
                        System.out.println("Your reservation has completed successfully.");
                    }
                }else {
                    System.out.println("Invalid seat.");
                }
                break;
            }
        }else if (buy_row == 3){
            for (int i = 0 ; i < row3.length ; i++){
                System.out.println("Enter the seat no. : ");
                int seat = input.nextInt();
                if (seat < row3.length+1) {
                    if (row3[seat - 1] == 1) {
                        System.out.println("Sorry! Already reserved");
                    } else {
                        row3[seat - 1] = 1;     //update the row3 array
                        add_details(buy_row, seat);
                        System.out.println("Your reservation has completed successfully.");
                    }
                }else {
                    System.out.println("Invalid seat.");
                }
                break;
            }
        }else {
            System.out.println("Error: This row number does not exist. Please select 1-3.");
        }
    }

    //print_seating_area method
    public static void print_seating_area(){
        System.out.println("""            
                \t*********** 
                \t*  STAGE  * 
                \t***********
                """);

        for (int i = 0 ; i < row1.length ; i++){
            if (i==0){
                System.out.print("    ");
            }if (i == row1.length/2){
                System.out.print(" ");
            }if (row1[i] == 0){
                System.out.print("O");
            }else {
                System.out.print("X");
            }
        }
        System.out.println();

        for (int i = 0 ; i < row2.length ; i++){
            if (i==0){
                System.out.print("  ");
            }if (i == row2.length/2){
                System.out.print(" ");
            }if (row2[i] == 0){
                System.out.print("O");
            }else {
                System.out.print("X");
            }
        }
        System.out.println();

        for (int i = 0 ; i< row3.length ; i++){
            if (i == row3.length/2){
                System.out.print(" ");
            }if (row3[i] == 0){
                System.out.print("O");
            }else {
                System.out.print("X");
            }
        }
        System.out.println();
    }

    //cancel_ticket method
    public static void cancel_ticket(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the row no. : ");
        int row = input.nextInt();

        if (row == 1){
            System.out.println("Enter the seat no. : ");
            int seat = input.nextInt();
            if (seat < row1.length+1) {
                if (row1[seat - 1] == 0) {
                    System.out.println("Seat is already available.");
                } else {
                    row1[seat - 1] = 0;     //update the row1 array
                    cancel_details(row, seat);  //remove the ticket info from the array list
                    System.out.println("Seat has cancelled successfully.");
                }
            }else {
                System.out.println("Invalid seat.");
            }
        }
        else if (row == 2){
            System.out.println("Enter the seat no. : ");
            int seat = input.nextInt();
            if (seat < row2.length+1) {
                if (row2[seat - 1] == 0) {
                    System.out.println("Seat is already available.");
                } else {
                    row2[seat - 1] = 0;     //update the row2 array
                    cancel_details(row, seat);
                    System.out.println("Seat has cancelled successfully.");
                }
            }else {
                System.out.println("Invalid seat.");
            }
        }else if (row == 3){
            System.out.println("Enter the seat no. : ");
            int seat = input.nextInt();
            if (seat < row3.length+1) {
                if (row3[seat - 1] == 0) {
                    System.out.println("Seat is already available.");
                } else {
                    row3[seat - 1] = 0;     //update the row3 array
                    cancel_details(row, seat);
                    System.out.println("Seat has cancelled successfully.");

                }
            }else {
                System.out.println("Invalid seat.");
            }
        }else {
            System.out.println("Wrong input");
        }
    }

    //show_available method
    public static void show_available(){
        System.out.println("Seats available in row 1 : ");
        for (int i = 0 ; i < row1.length ; i++){
            if (row1[i] == 0){
                System.out.print(i+1);
                if (i != row1.length - 1){
                    System.out.print(", ");
                }else {
                    System.out.println(".");
                }
            }else {
                System.out.print("");
            }
        }
        System.out.println();
        System.out.println("Seats available in row 2 : ");
        for (int i = 0; i < row2.length; i++){
            if (row2[i] == 0){
                System.out.print(i+1);
                if (i != row2.length - 1){
                    System.out.print(", ");
                }else {
                    System.out.println(".");
                }
            }else {
                System.out.print("");
            }
        }
        System.out.println();
        System.out.println("Seats available in row 3 : ");
        for (int i = 0; i < row3.length; i++) {
            if (row3[i] == 0){
                System.out.print(i+1);
                if (i != row3.length - 1){
                    System.out.print(", ");
                }else {
                    System.out.println(".");
                }
            }else {
                System.out.print("");
            }
        }
        System.out.println();
    }

    //save method
    public static void save(){
        try {
            FileWriter theatrefile = new FileWriter("Theatre.txt");

            //write the row 1
            for (int i = 0 ; i< row1.length ; i++){
                theatrefile.write(row1[i] + " ");
            }
            theatrefile.write("\n");

            //write the row 2
            for (int i = 0 ; i< row2.length ; i++){
                theatrefile.write(row2[i] + " ");
            }
            theatrefile.write("\n");

            //write the row 3
            for (int i = 0 ; i< row3.length ; i++){
                theatrefile.write(row3[i] + " ");
            }
            theatrefile.close();
            System.out.println("Successfully save to the file.");
        }catch (IOException e){
            System.out.println("An error occurred.");
        }
    }

    //load method
    public static void load(){
        try {
            File theatreObj = new File("Theatre.txt");
            Scanner theatreReader = new Scanner(theatreObj);

            //read the row 1
            for (int i = 0 ; i< row1.length; i++){
                row1[i] = theatreReader.nextInt();
            }

            //read the row 2
            for (int i = 0 ; i< row2.length; i++){
                row2[i] = theatreReader.nextInt();
            }

            //read the row 3
            for (int i = 0 ; i< row3.length; i++){
                row3[i] = theatreReader.nextInt();
            }
            System.out.println("File loaded successfully.");
        }catch (FileNotFoundException e){
            System.out.println("An error occurred.");
        }
    }

    //add_details method
    private static void add_details(int buy_row , int seat){
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Enter your name : ");
                String name = input.nextLine();
                System.out.println("Enter your surname : ");
                String surname = input.nextLine();
                System.out.println("Enter your E mail : ");
                String email = input.nextLine();
                if (email.contains("@") == false) {         //validate the email.
                    System.out.println("Wrong email.");
                    continue;
                }

                System.out.println("Enter your ticket price : ");
                double price = input.nextDouble();
                if(price <= 0){     //validate the price.
                    System.out.println("Wrong Price.");
                    input.nextLine();
                    continue;
                }
                Person user = new Person(name, surname, email);  //Object from the Person class
                Ticket ticket = new Ticket(buy_row, seat, price, user);     //Object from the Ticket class
                tickets.add(ticket);
                break;

            }catch (Exception e){
                System.out.println("Enter a valid value");
                input.nextLine();
            }
        }
    }

    //cancel_details method
    private static void cancel_details(int row , int seat){
        for (int i = 0 ; i < tickets.size() ; i++){
            Ticket ticket = tickets.get(i);
            if (ticket.getRow() == row && ticket.getSeat() == seat){
                tickets.remove(ticket);
                break;
            }
        }
    }

    //show_tickets_info method
    private static void show_tickets_info(){
        double totalPrice = 0;

        for (int i = 0 ; i< tickets.size() ; i++){
            Ticket ticket = tickets.get(i);
            ticket.print();
            System.out.println();
            totalPrice = totalPrice + ticket.getPrice();
        }
        System.out.println();
        System.out.println("Total : " + totalPrice);
    }

    //sort_tickets method
    private static void sort_tickets(){
        int n = tickets.toArray().length;

        for (int i = 0 ; i < n-1 ; i++){
            for (int j = 0 ; j < n-i-1 ; j++){
                if (tickets.get(j).price > tickets.get(j+1).price){
                    Ticket temp_value = tickets.get(j);
                    tickets.set(j, tickets.get(j+1));
                    tickets.set(j+1, temp_value);
                }
            }
        }
        System.out.println("Sorted tickets : ");
        for (int i = 0 ; i<n ; i++){
            tickets.get(i).print();
            System.out.println();
        }
    }

}