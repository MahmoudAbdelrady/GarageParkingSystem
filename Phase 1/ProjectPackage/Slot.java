package ProjectPackage;

public class Slot {
	private double width;
	private double depth;
	public Boolean statues;
	public int SlotNum;
	public static int cnt;
	Slot(double w, double d){
		width = w;
		depth = d;
		statues = true;
		cnt++;
		SlotNum = cnt;
	}
	public double getWidth() {
		return width;
	}
	public double getDepth() {
		return depth;
	}
}
