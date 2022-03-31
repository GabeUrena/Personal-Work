import java.util.*;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;

public class Atm {
	public static void main(String[]args) throws IOException {
//File will have the pin for your account and then the number of cash you have afterwards
		Scanner input = new Scanner(System.in);
		 File file = new File("C:\\Users\\puffy\\OneDrive\\Desktop\\filename.txt");
		 Scanner myReader = new Scanner(file);
		int realPin = myReader.nextInt();
		int attempts = 3;
		double balance = myReader.nextDouble();
		String data = realPin + " " + balance;
		// CHECK IF FILE IS EMPTY
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		BufferedWriter bw = new BufferedWriter(fw);
		
		System.out.println("Welcome to Simple Bank!\n");
		
		
	while(attempts >= 0) {	
		System.out.println("Please enter your pin\n");
		int enteredPin = input.nextInt();
		
		if (enteredPin == realPin) {
			System.out.println("Your balance is: $" + balance + "\nWould you like to"
					+ "\nWithdraw(1)"
					+ "\nDeposit(2)"
					+ "\nExit(3)");
			
			int option = input.nextInt();
			
			switch(option) {
			case 1:
				boolean insufficentFunds = true;
				if(balance == 0) {
					System.out.println("You have an insufficent amount of funds to withdraw from.");
					break;
				}
			while(insufficentFunds == true) {
				System.out.println("Enter how much you would like to withdraw?");
				double withdraw = input.nextDouble();
				
				if((balance - withdraw) < 0) {
					System.out.println("insufficent funds! Your balance is $" + balance);
				}else if((balance - withdraw) >= 0) {
					insufficentFunds = false;
					balance = balance - withdraw;
					System.out.println("\n\n\n");
					}
				}
				break;
			
			case 2:
				boolean insufficentFunds2 = true;
				while(insufficentFunds2 == true) {
					System.out.println("Enter how much you would like to deposit?");
					double deposit = input.nextDouble();
					
					if((deposit < 0)) {
						System.out.println("insufficent funds! You can deposit negative money");
					}else if(deposit >=  0) {
						insufficentFunds2 = false;
						balance = balance + deposit;
						System.out.println("\n\n\n");
						}
					}
					break;
					
			case 3:
				attempts = -1;
				System.out.println("Logging Off. Goodbye!");
				data = realPin + " " + balance;
				bw.write(data);
				bw.close();
				break;
				}
		
		}  if(enteredPin != realPin){
			attempts = attempts - 1;
			System.out.println(attempts + " attempts left");
		}
		}
		

}
}
