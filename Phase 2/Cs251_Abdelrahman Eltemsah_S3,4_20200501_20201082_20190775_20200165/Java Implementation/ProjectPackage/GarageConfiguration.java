package ProjectPackage;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class GarageConfiguration {
	public static void main(String[] args) throws IOException {
		File myFile = new File("GarageInfo.txt");
		Scanner ip = new Scanner(System.in);
		Slot s[];
		ArrayList<Vehicle> Vehicles = new ArrayList<Vehicle>();
		String ModelName;
		int vehicleIdentificationNumber;
		int ModelYear;
		double VehicleDepth;
		double VehicleWidth;
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
				if(confNum == 1) {
					while(true) {
						System.out.println("------------------------------");
						System.out.println("1- Park in");
						System.out.println("2- Park out");
						System.out.println("3- Exit");
						System.out.print("Enter your choice: ");
						int MenuChoice = ip.nextInt();
						while(MenuChoice != 1 && MenuChoice != 2 && MenuChoice != 3){
							System.out.println("Invalid Choice! Please enter again.");
							System.out.print("Enter your choice: ");
							MenuChoice = ip.nextInt();
						}
						if(MenuChoice == 1){
							while(true){
								System.out.print("Enter your vehicle's Model Name: ");
								ModelName = ip.next();
								System.out.print("Enter your vehicle's ID number: ");
								vehicleIdentificationNumber = ip.nextInt();
								System.out.print("Enter your vehicle's Model Year: ");
								ModelYear = ip.nextInt();
								System.out.print("Enter your vehicle's width and depth: ");
								VehicleWidth = ip.nextDouble();
								VehicleDepth = ip.nextDouble();
								Vehicle vec = new Vehicle(ModelName,vehicleIdentificationNumber , ModelYear , VehicleDepth , VehicleWidth);
								ParkIn.Parkin(s, SlotsNum , 1 , vec);
								Vehicles.add(vec);
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
						else if(MenuChoice == 2){
							int VIDNum;
							Boolean VehicleExistenceCheck = false;
							System.out.print("Enter your vehicle's ID number: ");
							VIDNum = ip.nextInt();
							for(int i = 0 ; i<Vehicles.size() ; i++){
								if(Vehicles.get(i).getIDNum() == VIDNum){		
									ParkOut.Parkout(s, SlotsNum, Vehicles.get(i));
									VehicleExistenceCheck = true;
									break;
								}
							}
							if(VehicleExistenceCheck == false){
								System.out.println("This Vehicle doesn't exist in the garage");
							}
						}
						else{
							break;
						}
					}
				}
				else if(confNum == 2) {
					while(true){
						System.out.println("------------------------------");
						System.out.println("1- Park in");
						System.out.println("2- Park out");
						System.out.println("3- Exit");
						System.out.print("Enter your choice: ");
						int MenuChoice = ip.nextInt();
						while(MenuChoice != 1 && MenuChoice != 2 && MenuChoice != 3){
							System.out.println("Invalid Choice! Please enter again.");
							System.out.print("Enter your choice: ");
							MenuChoice = ip.nextInt();
						}
						if(MenuChoice == 1){	
							while(true) {
								System.out.print("Enter your vehicle's Model Name: ");
								ModelName = ip.next();
								System.out.print("Enter your vehicle's ID number: ");
								vehicleIdentificationNumber = ip.nextInt();
								System.out.print("Enter your vehicle's Model Year: ");
								ModelYear = ip.nextInt();
								System.out.print("Enter your vehicle's width and depth: ");
								VehicleWidth = ip.nextDouble();
								VehicleDepth = ip.nextDouble();
								Vehicle vec = new Vehicle(ModelName,vehicleIdentificationNumber , ModelYear , VehicleDepth , VehicleWidth);
								ParkIn.Parkin(s, SlotsNum , 2 , vec);
								Vehicles.add(vec);
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
						else if(MenuChoice == 2){
							int VIDNum;
							Boolean VehicleExistenceCheck = false;
							System.out.print("Enter your vehicle's ID number: ");
							VIDNum = ip.nextInt();
							for(int i = 0 ; i<Vehicles.size() ; i++){
								if(Vehicles.get(i).getIDNum() == VIDNum){		
									ParkOut.Parkout(s, SlotsNum, Vehicles.get(i));
									VehicleExistenceCheck = true;
									break;
								}
							}
							if(VehicleExistenceCheck == false){
								System.out.println("This Vehicle doesn't exist in the garage");
							}
						}
						else{
							break;
						}
					}
				}
				fWriter.close();
				System.out.println("Garage's Total Income : "+GarageTotalIncome.TotalIncome());
				System.out.println("Garage's Total Parked Vehicles : "+Vehicles.size());
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
					while (true){
						System.out.println("------------------------------");
						System.out.println("1- Park in");
						System.out.println("2- Park out");
						System.out.println("3- Exit");
						System.out.print("Enter your choice: ");
						int MenuChoice = ip.nextInt();
						while(MenuChoice != 1 && MenuChoice != 2 && MenuChoice != 3){
							System.out.println("Invalid Choice! Please enter again.");
							System.out.print("Enter your choice: ");
							MenuChoice = ip.nextInt();
						}
						if(MenuChoice == 1){	
							while(true) {
								System.out.print("Enter your vehicle's Model Name: ");
								ModelName = ip.next();
								System.out.print("Enter your vehicle's ID number: ");
								vehicleIdentificationNumber = ip.nextInt();
								System.out.print("Enter your vehicle's Model Year: ");
								ModelYear = ip.nextInt();
								System.out.print("Enter your vehicle's width and depth: ");
								VehicleWidth = ip.nextDouble();
								VehicleDepth = ip.nextDouble();
								Vehicle vec = new Vehicle(ModelName,vehicleIdentificationNumber , ModelYear , VehicleDepth , VehicleWidth);
								ParkIn.Parkin(s, SN , 1 , vec);
								Vehicles.add(vec);
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
						else if(MenuChoice == 2){
							int VIDNum;
							Boolean VehicleExistenceCheck = false;
							System.out.print("Enter your vehicle's ID number: ");
							VIDNum = ip.nextInt();
							for(int i = 0 ; i<Vehicles.size() ; i++){
								if(Vehicles.get(i).getIDNum() == VIDNum){		
									ParkOut.Parkout(s, SN, Vehicles.get(i));
									VehicleExistenceCheck = true;
									break;
								}
							}
							if(VehicleExistenceCheck == false){
								System.out.println("This Vehicle doesn't exist in the garage");
							}
						}
						else{
							break;
						}
					}
				}
				else if(confCheck == 'B') {
					while(true){
						System.out.println("------------------------------");
						System.out.println("1- Park in");
						System.out.println("2- Park out");
						System.out.println("3- Exit");
						System.out.print("Enter your choice: ");
						int MenuChoice = ip.nextInt();
						while(MenuChoice != 1 && MenuChoice != 2 && MenuChoice != 3){
							System.out.println("Invalid Choice! Please enter again.");
							System.out.print("Enter your choice: ");
							MenuChoice = ip.nextInt();
						}
						if(MenuChoice == 1){
							while(true) {
								System.out.print("Enter your vehicle's Model Name: ");
								ModelName = ip.next();
								System.out.print("Enter your vehicle's ID number: ");
								vehicleIdentificationNumber = ip.nextInt();
								System.out.print("Enter your vehicle's Model Year: ");
								ModelYear = ip.nextInt();
								System.out.print("Enter your vehicle's width and depth: ");
								VehicleWidth = ip.nextDouble();
								VehicleDepth = ip.nextDouble();
								Vehicle vec = new Vehicle(ModelName,vehicleIdentificationNumber , ModelYear , VehicleDepth , VehicleWidth);
								ParkIn.Parkin(s, SN , 2 , vec);
								Vehicles.add(vec);
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
						else if(MenuChoice == 2){
							int VIDNum;
							Boolean VehicleExistenceCheck = false;
							System.out.print("Enter your vehicle's ID number: ");
							VIDNum = ip.nextInt();
							for(int i = 0 ; i<Vehicles.size() ; i++){
								if(Vehicles.get(i).getIDNum() == VIDNum){		
									ParkOut.Parkout(s, SN, Vehicles.get(i));
									VehicleExistenceCheck = true;
									break;
								}
							}
							if(VehicleExistenceCheck == false){
								System.out.println("This Vehicle doesn't exist in the garage");
							}
						}
						else{
							break;
						}
					}
				}
				filesc.close();
				System.out.println("Garage's Total Income : "+GarageTotalIncome.TotalIncome());
				System.out.println("Garage's Total Parked Vehicles : "+Vehicles.size());
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
			if(confNum == 1) {
				while(true){
					System.out.println("------------------------------");
					System.out.println("1- Park in");
					System.out.println("2- Park out");
					System.out.println("3- Exit");
					System.out.print("Enter your choice: ");
					int MenuChoice = ip.nextInt();
					while(MenuChoice != 1 && MenuChoice != 2 && MenuChoice != 3){
						System.out.println("Invalid Choice! Please enter again.");
						System.out.print("Enter your choice: ");
						MenuChoice = ip.nextInt();
					}
					if(MenuChoice == 1){
						while(true) {
							System.out.print("Enter your vehicle's Model Name: ");
							ModelName = ip.next();
							System.out.print("Enter your vehicle's ID number: ");
							vehicleIdentificationNumber = ip.nextInt();
							System.out.print("Enter your vehicle's Model Year: ");
							ModelYear = ip.nextInt();
							System.out.print("Enter your vehicle's width and depth: ");
							VehicleWidth = ip.nextDouble();
							VehicleDepth = ip.nextDouble();
							Vehicle vec = new Vehicle(ModelName,vehicleIdentificationNumber , ModelYear , VehicleDepth , VehicleWidth);
							ParkIn.Parkin(s, SlotsNum , 1 , vec);
							Vehicles.add(vec);
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
					else if(MenuChoice == 2){
						int VIDNum;
						Boolean VehicleExistenceCheck = false;
						System.out.print("Enter your vehicle's ID number: ");
						VIDNum = ip.nextInt();
						for(int i = 0 ; i<Vehicles.size() ; i++){
							if(Vehicles.get(i).getIDNum() == VIDNum){		
								ParkOut.Parkout(s, SlotsNum, Vehicles.get(i));
								VehicleExistenceCheck = true;
								break;
							}
						}
						if(VehicleExistenceCheck == false){
							System.out.println("This Vehicle doesn't exist in the garage");
						}
					}
					else{
						break;
					}
				}
			}
			else if(confNum == 2) {
				while(true){
					System.out.println("------------------------------");
					System.out.println("1- Park in");
					System.out.println("2- Park out");
					System.out.println("3- Exit");
					System.out.print("Enter your choice: ");
					int MenuChoice = ip.nextInt();
					while(MenuChoice != 1 && MenuChoice != 2 && MenuChoice != 3){
						System.out.println("Invalid Choice! Please enter again.");
						System.out.print("Enter your choice: ");
						MenuChoice = ip.nextInt();
					}
					if(MenuChoice == 1){
						while(true) {
							System.out.print("Enter your vehicle's Model Name: ");
							ModelName = ip.next();
							System.out.print("Enter your vehicle's ID number: ");
							vehicleIdentificationNumber = ip.nextInt();
							System.out.print("Enter your vehicle's Model Year: ");
							ModelYear = ip.nextInt();
							System.out.print("Enter your vehicle's width and depth: ");
							VehicleWidth = ip.nextDouble();
							VehicleDepth = ip.nextDouble();
							Vehicle vec = new Vehicle(ModelName,vehicleIdentificationNumber , ModelYear , VehicleDepth , VehicleWidth);
							ParkIn.Parkin(s, SlotsNum , 2 , vec);
							Vehicles.add(vec);
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
					else if(MenuChoice == 2){
						int VIDNum;
						Boolean VehicleExistenceCheck = false;
						System.out.print("Enter your vehicle's ID number: ");
						VIDNum = ip.nextInt();
						for(int i = 0 ; i<Vehicles.size() ; i++){
							if(Vehicles.get(i).getIDNum() == VIDNum){		
								ParkOut.Parkout(s, SlotsNum, Vehicles.get(i));
								VehicleExistenceCheck = true;
								break;
							}
						}
						if(VehicleExistenceCheck == false){
							System.out.println("This Vehicle doesn't exist in the garage");
						}
					}
					else{
						break;
					}
				}
			}
			fWriter.close();
			System.out.println("Garage's Total Income : "+GarageTotalIncome.TotalIncome());
			System.out.println("Garage's Total Parked Vehicles : "+Vehicles.size());
		}
		ip.close();
	}
}