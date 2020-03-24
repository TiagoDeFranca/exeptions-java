package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room Number: ");
		int number = sc.nextInt();
		
		System.out.println("CheckIn Date(\"dd/MM/yyyy): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("CheckOut Date(\"dd/MM/yyyy): ");
		Date checkOut = sdf.parse(sc.next());
		
		if(!checkOut.after(checkIn)) {
			System.out.println("Error in Reservation: Check-Out date must be after check-in date!!!");
		}
		
		else {
			Reservation reservation = new Reservation(number, checkIn, checkOut);
			System.out.println("Reservation: " + reservation);
			
			System.out.println();
			System.out.println("Enter data to update reservation: ");
			System.out.println("CheckIn Date(\"dd/MM/yyyy): ");
			checkIn = sdf.parse(sc.next());
			System.out.println("CheckOut Date(\"dd/MM/yyyy): ");
			checkOut = sdf.parse(sc.next());
			
			Date now = new Date();
			if(checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in Reservation: Check-Out date must be after check-in date!!!");
			}
			else if(!checkOut.after(checkIn)) {
				System.out.println("Error in Reservation: Check-Out date must be after check-in date!!!");
			}
			else{
				reservation.updateDates(checkIn, checkOut);
				System.out.println("Reservation: " + reservation);
			}
			}
			
			
		sc.close();
		}
	
		
	}
