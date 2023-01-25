package ProjectPackage;

public class Slot {
	private double width;
	private double depth;
	public Boolean statues;
	public int SlotNum;
	public int VehicleIDNum;
	public static int cnt;
	Slot(double w, double d){
		width = w;
		depth = d;
		statues = true;
		VehicleIDNum = 0;
		cnt++;
		SlotNum = cnt;
	}
	public double getWidth() {
		return width;
	}
	public double getDepth() {
		return depth;
	}
	public int getVIDNum(){
		return VehicleIDNum;
	}
}
