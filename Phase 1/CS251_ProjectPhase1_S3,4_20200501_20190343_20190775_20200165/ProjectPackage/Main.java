package ProjectPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
public class Main {
	public static void ParkIn(Slot sl[] , int SN , int confNum , Double cW , Double cD) {
		if(confNum == 1) {
			for(int i = 0 ; i<SN ;i++) {
				if(sl[i].getWidth() >= cW && sl[i].getDepth() >= cD && sl[i].statues == true) {
					Date d=new Date(); 
					String st = d.toString();
					sl[i].statues = false;
					System.out.println("Arrival Time : "+st);
					System.out.println("Parked at slot number "+sl[i].SlotNum);
					DisplayAvSlots(sl, SN);
					break;
				}
			}
		}
		else {
			Double calc , min;
			int arrSize = 0;
			int arridx = 0;
			for(int i = 0 ; i<SN ;i++) {
				if(sl[i].getWidth() >= cW && sl[i].getDepth() >= cD && sl[i].statues == true) {
					arrSize++;
				}
			}
			Double arr[] = new Double[arrSize];
			for(int i = 0 ; i<SN ;i++) {
				if(sl[i].getWidth() >= cW && sl[i].getDepth() >= cD && sl[i].statues == true) {
					calc = sl[i].getWidth() + sl[i].getDepth();
					arr[arridx] = calc;
					arridx++;
				}
			}
			min = arr[0];
			for(int i = 1 ; i<arrSize ; i++) {
				if(arr[i] < min) min = arr[i];
			}
			for(int i = 0 ; i < SN ; i++) {
				if(sl[i].getWidth() + sl[i].getDepth() == min && sl[i].statues == true) {
					Date d=new Date(); 
					String st = d.toString();
					sl[i].statues = false;
					System.out.println("Arrival Time : "+st);
					System.out.println("Parked at slot number "+sl[i].SlotNum);
					DisplayAvSlots(sl, SN);
					break;
				}
			}
		}
	}
	public static void DisplayAvSlots(Slot sl[] , int SN) {
		System.out.println("******************************");
		System.out.println("*       Available Slots      *");
		System.out.println("******************************");
		for(int i = 0 ; i<SN ; i++) {
			if(sl[i].statues == true) {
				System.out.println("Slot Number : "+sl[i].SlotNum);
				System.out.println("Width : "+sl[i].getWidth());
				System.out.println("Depth : "+sl[i].getDepth());
				System.out.println("------------------------------");
			}
		}
	}
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
						ParkIn(s, SlotsNum , 1 , ipwidth , ipdepth);
						//DisplayAvSlots(s, SlotsNum);
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
						else if(choice == 'n') {
							break;
							}
						}
					}
				}
				else if(confNum == 2) {
					while(true) {
						System.out.print("Enter your vehicle's width and depth: ");
						Double ipwidth = ip.nextDouble() , ipdepth = ip.nextDouble();
						ParkIn(s, SlotsNum , 2 , ipwidth , ipdepth);
						//DisplayAvSlots(s, SlotsNum);
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
						else if(choice == 'n') {
							break;
							}
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
						ParkIn(s, SN , 1 , ipwidth , ipdepth);
						//DisplayAvSlots(s, SN);
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
						else if(choice == 'n') {
							break;
							}
						}
					}
				}
				else if(confCheck == 'B') {
					while(true) {
						System.out.print("Enter your vehicle's width and depth: ");
						Double ipwidth = ip.nextDouble() , ipdepth = ip.nextDouble();
						ParkIn(s, SN , 2 , ipwidth , ipdepth);
						//DisplayAvSlots(s, SN);
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
						else if(choice == 'n') {
							break;
							}
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
					ParkIn(s, SlotsNum , 1 , ipwidth , ipdepth);
					//DisplayAvSlots(s, SlotsNum);
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
					else if(choice == 'n') {
						break;
						}
					}
				}
			}
			else if(confNum == 2) {
				while(true) {
					System.out.print("Enter your vehicle's width and depth: ");
					Double ipwidth = ip.nextDouble() , ipdepth = ip.nextDouble();
					ParkIn(s, SlotsNum , 2 , ipwidth , ipdepth);
					//DisplayAvSlots(s, SlotsNum);
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
					else if(choice == 'n') {
						break;
						}
					}
				}
			}
			fWriter.close();
		}
		ip.close();
	}
}