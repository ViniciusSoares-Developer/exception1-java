package program;

import model.entities.Reservation;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Program {
    public static void main(String[] arg) throws ParseException {
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        List<Reservation> reservations = new ArrayList<>();

        System.out.print("Room number: ");
        int roomNumber = scan.nextInt();
        System.out.print("Check-in date (dd/MM/yyyy): ");
        Date checkIn = date.parse(scan.next());
        System.out.print("Check-out date (dd/MM/yyyy): ");
        Date checkOut = date.parse(scan.next());
        if(!checkOut.after(checkIn)) {
            System.out.println("Error in reservation: Check-out date must be after check-in date");
        }else {
            reservations.add(new Reservation(roomNumber, checkIn, checkOut));
            System.out.println(reservations.get(0));

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = date.parse(scan.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = date.parse(scan.next());

            if(checkOut.before(new Date()) || checkIn.before(new Date())){
                System.out.println("Error in reservation: Check-out date must be after check-in date");
            }else if(!checkOut.after(checkIn)){
                System.out.println("Error");
            }else{
                reservations.get(0).updateDates(checkIn, checkOut);
                System.out.println(reservations.get(0));
            }
        }
        scan.close();
    }
}
