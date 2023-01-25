package ProjectPackage;
import java.time.format.DateTimeFormatter;
import java.time.Duration;
import java.time.LocalDateTime;

public class ParkOut {
	public static double totalIncome;
    public static void Parkout(Slot sl[] , int slotsnum , Vehicle vec){
		for(int i = 0 ; i<slotsnum ; i++){
			if(sl[i].VehicleIDNum == vec.getIDNum()){
				DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("dd/MM/yy HH:mm:ss");
				vec.ParkOutTime = LocalDateTime.now();
				System.out.println("Departure Time : "+dtf.format(vec.ParkOutTime).toString());
				sl[i].statues = true;
				sl[i].VehicleIDNum = 0;
			}
		}
		Duration ParkingDuration =  Duration.between(vec.ParkInTime,vec.ParkOutTime);
		long hours = ParkingDuration.toHours();
		ParkingDuration = ParkingDuration.minusHours(hours);
		long minutes = ParkingDuration.toMinutes();
		ParkingDuration = ParkingDuration.minusMinutes(minutes);
		long seconds = ParkingDuration.getSeconds();
		System.out.println("Duration of parking : "+hours+" Hours, "+minutes+" Minutes and "+seconds+" Seconds");
		double ParkingFees = 0;
		if(seconds >= 0 || minutes >= 0){
			ParkingFees += 5;
			totalIncome += 5;
		}
		if(hours >= 1){
			ParkingFees = hours * 5;
			totalIncome += ParkingFees;
		} 
		System.out.println("Parking Fees: "+ParkingFees);
	}
}
