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

        if(!checkOut.after(checkIn)){
            System.out.println("Error in reservation: Reservation dates for update must be future dates");
        }else {
            reservations.add(new Reservation(roomNumber, checkIn, checkOut));
            System.out.println(reservations.get(0));
            System.out.println();

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = date.parse(scan.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = date.parse(scan.next());

            String error = reservations.get(0).updateDates(checkIn, checkOut);
            if (error != null) {
                System.out.println("Error in reservation: " + error);
            } else {
                System.out.println(reservations.get(0));
            }
        }
        scan.close();
    }
}
