package ProjectPackage;

import java.util.Date;

public class Parking {
	public static void ParkIn(Slot sl[] , int slotsnum , int confNum , Double vehicleWidth , Double vehicleDepth) {
		if(confNum == 1) {
            boolean checkVehicle = false;
			for(int i = 0 ; i<slotsnum ;i++) {
				if(sl[i].getWidth() >= vehicleWidth && sl[i].getDepth() >= vehicleDepth && sl[i].statues == true) {
					Date d=new Date(); 
					String st = d.toString();
					sl[i].statues = false;
                    checkVehicle = true;
					System.out.println("Arrival Time : "+st);
					System.out.println("Parked at slot number "+sl[i].SlotNum);
					Slot.DisplayAvSlots(sl, slotsnum);
					break;
				}
			}
            if(checkVehicle == false){
                System.out.println("There is no suitable slot for the vehicle");
            }
		}
		else {
			Double calc , min;
			int arrSize = 0;
			int arridx = 0;
			for(int i = 0 ; i<slotsnum ;i++) {
				if(sl[i].getWidth() >= vehicleWidth && sl[i].getDepth() >= vehicleDepth && sl[i].statues == true) {
					arrSize++;
				}
			}
			Double arr[] = new Double[arrSize];
            boolean checkVehicle = false;
			for(int i = 0 ; i<slotsnum ;i++) {
				if(sl[i].getWidth() >= vehicleWidth && sl[i].getDepth() >= vehicleDepth && sl[i].statues == true) {
					calc = sl[i].getWidth() + sl[i].getDepth();
					arr[arridx] = calc;
					arridx++;
                    checkVehicle = true;
				}
			}
            /*if(checkVehicle == false){
                System.out.println("There is no suitable slot for the vehicle");
            }*/
            //else{
                min = arr[0];
                for(int i = 1 ; i<arrSize ; i++) {
                    if(arr[i] < min) min = arr[i];
                }
                for(int i = 0 ; i < slotsnum ; i++) {
                    if(sl[i].getWidth() + sl[i].getDepth() == min && sl[i].statues == true) {
                        Date d=new Date(); 
                        String st = d.toString();
                        sl[i].statues = false;
                        System.out.println("Arrival Time : "+st);
                        System.out.println("Parked at slot number "+sl[i].SlotNum);
                        Slot.DisplayAvSlots(sl, slotsnum);
                        break;
                    }
                }
            //}
		}
	}
	public static void ParkOut(Slot sl[] , int slotsnum , int confNum , Double vehicleWidth , Double vehicleDepth)
	{
		if(confNum == 1) {
           //boolean checkVehicle = false;
			for(int i = 0 ; i<slotsnum ;i++) {
				if(sl[i].getWidth() >= vehicleWidth && sl[i].getDepth() >= vehicleDepth && sl[i].statues == true) {
					Date D=new Date(); 
					String sT = D.toString();
					sl[i].statues = false;
                    //checkVehicle = true;
					System.out.println("Departure Time : "+sT);
					System.out.println("Parked at slot number "+sl[i].SlotNum);
					Slot.DisplayAvSlots(sl, slotsnum);
					break;
				}
			}
            /*if(checkVehicle == false){
                System.out.println("There is no suitable slot for the vehicle");
            }*/
		}
		else {
			Double calc , min;
			int arrSize = 0;
			int arridx = 0;
			for(int i = 0 ; i<slotsnum ;i++) {
				///if(sl[i].getWidth() >= vehicleWidth && sl[i].getDepth() >= vehicleDepth && sl[i].statues == true) {
					arrSize++;
				//}
			}
			Double arr[] = new Double[arrSize];
            boolean checkVehicle = false;
			for(int i = 0 ; i<slotsnum ;i++) {
				//if(sl[i].getWidth() >= vehicleWidth && sl[i].getDepth() >= vehicleDepth && sl[i].statues == true) {
					calc = sl[i].getWidth() + sl[i].getDepth();
					arr[arridx] = calc;
					arridx++;
                    //checkVehicle = true;
				//}
			}
            /*if(checkVehicle == false){
                System.out.println("There is no suitable slot for the vehicle");
            }*/
            //else{
                min = arr[0];
                for(int i = 1 ; i<arrSize ; i++) {
                    if(arr[i] < min) min = arr[i];
                }
                for(int i = 0 ; i < slotsnum ; i++) {
                    if(sl[i].getWidth() + sl[i].getDepth() == min && sl[i].statues == true) {
                        Date D=new Date(); 
                        String sT = D.toString();
                        sl[i].statues = false;
                        System.out.println("Departure Time : "+sT);
                        System.out.println("Parked at slot number "+sl[i].SlotNum);
                        Slot.DisplayAvSlots(sl, slotsnum);
                        break;
                    }
                }
           // }
		}
	}
  public int fees=(sT-st)*5;

}
