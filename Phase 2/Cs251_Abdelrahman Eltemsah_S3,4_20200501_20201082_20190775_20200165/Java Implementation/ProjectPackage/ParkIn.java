package ProjectPackage;
//import java.util.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ParkIn {
	public static void Parkin(Slot sl[] , int slotsnum , int ParkingConfiguration , Vehicle vec) {
		if(ParkingConfiguration == 1) {
            boolean checkVehicle = false;
			for(int i = 0 ; i<slotsnum ;i++) {
				if(sl[i].getWidth() >= vec.getVehicleWidth() && sl[i].getDepth() >= vec.getVehicleDepth() && sl[i].statues == true) {
					sl[i].statues = false;
					sl[i].VehicleIDNum = vec.getIDNum();
                    checkVehicle = true;
					DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
					vec.ParkInTime = LocalDateTime.now();
					System.out.println("Arrival Time : "+dtf.format(vec.ParkInTime).toString());
					System.out.println("Parked at slot number "+sl[i].SlotNum);
					DisplayAvailableSlots.DisplayAvSlots(sl, slotsnum);
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
				if(sl[i].getWidth() >= vec.getVehicleWidth() && sl[i].getDepth() >= vec.getVehicleDepth() && sl[i].statues == true) {
					arrSize++;
				}
			}
			Double arr[] = new Double[arrSize];
            boolean checkVehicle = false;
			for(int i = 0 ; i<slotsnum ;i++) {
				if(sl[i].getWidth() >= vec.getVehicleWidth() && sl[i].getDepth() >= vec.getVehicleDepth() && sl[i].statues == true) {
					calc = sl[i].getWidth() + sl[i].getDepth();
					arr[arridx] = calc;
					arridx++;
                    checkVehicle = true;
				}
			}
            if(checkVehicle == false){
                System.out.println("There is no suitable slot for the vehicle");
            }
            else{
                min = arr[0];
                for(int i = 1 ; i<arrSize ; i++) {
                    if(arr[i] < min) min = arr[i];
                }
                for(int i = 0 ; i < slotsnum ; i++) {
                    if(sl[i].getWidth() + sl[i].getDepth() == min && sl[i].statues == true) {
                        sl[i].statues = false;
						sl[i].VehicleIDNum = vec.getIDNum();
						DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
						vec.ParkInTime = LocalDateTime.now();
                        System.out.println("Arrival Time : "+dtf.format(vec.ParkInTime).toString());
                        System.out.println("Parked at slot number "+sl[i].SlotNum);
                        DisplayAvailableSlots.DisplayAvSlots(sl, slotsnum);
                        break;
                    }
                }
            }
		}
	}
	
}
