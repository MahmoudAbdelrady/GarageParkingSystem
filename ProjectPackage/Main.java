package ProjectPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Main {
	public static void main(String[] args) throws IOException {
		File myFile = new File("GarageInfo.txt");
		Scanner ip = new Scanner(System.in);
		Slot s[];
		if(myFile.exists()) {
			if(myFile.length() == 0) {
				FileWriter fWriter = new FileWriter("GarageInfo.txt");
				System.out.print("Enter the garage slots number: ");
				int SlotsNum = ip.nextInt();
				s = new Slot[SlotsNum];
				fWriter.write(SlotsNum+"");
				for(int i = 0 ; i < SlotsNum ; i++) {
					System.out.printf("Enter slot %d width and depth: ",(i+1));
					Double width = ip.nextDouble();
					Double depth = ip.nextDouble();
					s[i] = new Slot(width,depth);
					fWriter.write("\n"+width+"  "+depth);
				}
				
				System.out.println("------------------------------");
				System.out.println("Parking configurations: ");
				System.out.println("1- First come first served slots");
				System.out.println("2- Best-fit approach");
				System.out.print("Choose the parking configuration number you want: ");
				int confNum = ip.nextInt();
				if(confNum != 1 && confNum != 2) {
					System.out.print("Invalid choice. Please enter again: ");
					confNum = ip.nextInt();
				}
				if(confNum == 1) {
					fWriter.write("\nFirst come first served slots");
				}
				else if(confNum == 2) {
					fWriter.write("\nBest-fit approach");
				}
				System.out.println("------------------------------");
				if(confNum == 1) {
					while(true) {
						System.out.print("Enter your vehicle's width and depth: ");
						Double ipwidth = ip.nextDouble() , ipdepth = ip.nextDouble();
						Parking.ParkIn(s, SlotsNum , 1 , ipwidth , ipdepth);
						System.out.print("Want to park again ?(y/n)");
						char choice = ip.next().charAt(0);
						while(choice != 'y' && choice != 'n') {
							System.out.print("Invalid choice. Please type again:");
							choice = ip.next().charAt(0);
						}
						if(choice == 'y'){
							int checkav = 0;
							for(int i = 0 ; i<SlotsNum ; i++){
								if(s[i].statues == false) checkav++;
							}
							if(checkav == SlotsNum) {
								System.out.println("There is no available slots.");
								break;
							}
						}
						else if(choice == 'n') {
							break;
						}
					}
				}
				else if(confNum == 2) {
					while(true) {
						System.out.print("Enter your vehicle's width and depth: ");
						Double ipwidth = ip.nextDouble() , ipdepth = ip.nextDouble();
						Parking.ParkIn(s, SlotsNum , 2 , ipwidth , ipdepth);
						System.out.print("Want to park again ?(y/n)");
						char choice = ip.next().charAt(0);
						while(choice != 'y' && choice != 'n') {
							System.out.print("Invalid choice. Please type again:");
							choice = ip.next().charAt(0);
						}
						if(choice == 'y'){
							int checkav = 0;
							for(int i = 0 ; i<SlotsNum ; i++){
								if(s[i].statues == false) checkav++;
							}
							if(checkav == SlotsNum) {
								System.out.println("There is no available slots.");
								break;
							}
						}
						else if(choice == 'n') {
							break;
						}
					}
				}
				fWriter.close();
			}
			else {
				Scanner filesc = new Scanner(myFile);
				int SN = filesc.nextInt();
				s = new Slot[SN];
			    for(int i = 0 ; i < SN ; i++) {
			    	if (filesc.hasNextDouble()) {
					      Double width = filesc.nextDouble();
					      Double depth = filesc.nextDouble();
					      s[i] = new Slot(width,depth);
					  }
				}
			    char confCheck = filesc.next().charAt(0);
				if(confCheck == 'F') {
					while(true) {
						System.out.print("Enter your vehicle's width and depth: ");
						Double ipwidth = ip.nextDouble() , ipdepth = ip.nextDouble();
						Parking.ParkIn(s, SN , 1 , ipwidth , ipdepth);
						System.out.print("Want to park again ?(y/n)");
						char choice = ip.next().charAt(0);
						while(choice != 'y' && choice != 'n') {
							System.out.print("Invalid choice. Please type again:");
							choice = ip.next().charAt(0);
						}
						if(choice == 'y'){
							int checkav = 0;
							for(int i = 0 ; i<SN ; i++){
								if(s[i].statues == false) checkav++;
							}
							if(checkav == SN) {
								System.out.println("There is no available slots.");
								break;
							}
						}
						else if(choice == 'n') {
							break;
						}
					}
				}
				else if(confCheck == 'B') {
					while(true) {
						System.out.print("Enter your vehicle's width and depth: ");
						Double ipwidth = ip.nextDouble() , ipdepth = ip.nextDouble();
						Parking.ParkIn(s, SN , 2 , ipwidth , ipdepth);
						System.out.print("Want to park again ?(y/n)");
						char choice = ip.next().charAt(0);
						while(choice != 'y' && choice != 'n') {
							System.out.print("Invalid choice. Please type again:");
							choice = ip.next().charAt(0);
						}
						if(choice == 'y'){
							int checkav = 0;
							for(int i = 0 ; i<SN ; i++){
								if(s[i].statues == false) checkav++;
							}
							if(checkav == SN) {
								System.out.println("There is no available slots.");
								break;
							}
						}
						else if(choice == 'n') {
							break;
						}
					}
				}
				filesc.close();
			}
		}
		else {
			
			FileWriter fWriter = new FileWriter("GarageInfo.txt");
			System.out.print("Enter the garage slots number: ");
			int SlotsNum = ip.nextInt();
			s = new Slot[SlotsNum];
			fWriter.write(SlotsNum+"");
			for(int i = 0 ; i < SlotsNum ; i++) {
				System.out.printf("Enter slot %d width and depth: ",(i+1));
				Double width = ip.nextDouble();
				Double depth = ip.nextDouble();
				s[i] = new Slot(width,depth);
				fWriter.write("\n"+width+"  "+depth);
			}
			
			System.out.println("------------------------------");
			System.out.println("Parking configurations: ");
			System.out.println("1- First come first served slots");
			System.out.println("2- Best-fit approach");
			System.out.print("Choose the parking configuration number you want: ");
			int confNum = ip.nextInt();
			if(confNum != 1 && confNum != 2) {
				System.out.print("Invalid choice. Please enter again: ");
				confNum = ip.nextInt();
			}
			if(confNum == 1) {
				fWriter.write("\nFirst come first served slots");
			}
			else if(confNum == 2) {
				fWriter.write("\nBest-fit approach");
			}
			System.out.println("------------------------------");
			if(confNum == 1) {
				while(true) {
					System.out.print("Enter your vehicle's width and depth: ");
					Double ipwidth = ip.nextDouble() , ipdepth = ip.nextDouble();
					Parking.ParkIn(s, SlotsNum , 1 , ipwidth , ipdepth);
					System.out.print("Want to park again ?(y/n)");
					char choice = ip.next().charAt(0);
					while(choice != 'y' && choice != 'n') {
						System.out.print("Invalid choice. Please type again:");
						choice = ip.next().charAt(0);
					}
					if(choice == 'y'){
						int checkav = 0;
						for(int i = 0 ; i<SlotsNum ; i++){
							if(s[i].statues == false) checkav++;
						}
						if(checkav == SlotsNum) {
							System.out.println("There is no available slots.");
							break;
						}
					}
					else if(choice == 'n') {
						break;
					}
					Parking.ParkOut(s, SlotsNum , 1 , ipwidth ,ipdepth);
					Parking obj= new Parking() ;
					System.out.print("Parking fees :"+ obj.fees);
				}
			}
			else if(confNum == 2) {
				while(true) {
					System.out.print("Enter your vehicle's width and depth: ");
					Double ipwidth = ip.nextDouble() , ipdepth = ip.nextDouble();
					Parking.ParkIn(s, SlotsNum , 2 , ipwidth , ipdepth);
					System.out.print("Want to park again ?(y/n)");
					char choice = ip.next().charAt(0);
					while(choice != 'y' && choice != 'n') {
						System.out.print("Invalid choice. Please type again:");
						choice = ip.next().charAt(0);
					}
					if(choice == 'y'){
						int checkav = 0;
						for(int i = 0 ; i<SlotsNum ; i++){
							if(s[i].statues == false) checkav++;
						}
						if(checkav == SlotsNum) {
							System.out.println("There is no available slots.");
							break;
						}
					}
					else if(choice == 'n') {
						break;
					}
					Parking.ParkOut(s, SlotsNum , 2 , ipwidth ,ipdepth);
					Parking obj= new Parking() ;
					System.out.print("Parking fees :"+ obj.fees);

				}
			}
			fWriter.close();
		}
		ip.close();
	}
}