package ProjectPackage;
import java.time.LocalDateTime;

public class Vehicle {
	private String ModelName;
	private int IDNum;
	private int ModelYear;
	private double VehicleDepth;
	private double VehicleWidth;
	public LocalDateTime ParkInTime;
	public LocalDateTime ParkOutTime;
	Vehicle(String modelname , int idnum , int modelyear , double VehicleD , double VehicleW){
		ModelName = modelname;
		IDNum = idnum;
		ModelYear = modelyear;
		VehicleDepth = VehicleD;
		VehicleWidth = VehicleW;
	}
	public String getModelName() {
		return ModelName;
	}
	public int getIDNum() {
		return IDNum;
	}
	public int getModelYear() {
		return ModelYear;
	}
	public double getVehicleDepth() {
		return VehicleDepth;
	}
	public double getVehicleWidth() {
		return VehicleWidth;
	}
}
