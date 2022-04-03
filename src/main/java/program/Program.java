package program;

import model.entities.Reservation;
import model.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Program {
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = scan.nextInt();
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkIn = date.parse(scan.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOut = date.parse(scan.next());

            Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
            System.out.println(reservation);
            System.out.println();

            System.out.println("Enter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            checkIn = date.parse(scan.next());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            checkOut = date.parse(scan.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println(reservation);

        }catch(InputMismatchException e){
            System.out.println("Invalid number type");
        }catch (ParseException e) {
            System.out.println("Invalid date format");
        }catch(DomainException e){
            System.out.print("Error in reservation: "+e.getMessage());
        }catch(RuntimeException e){
            System.out.println("Unexpected error");
        }
        scan.close();
    }
}
