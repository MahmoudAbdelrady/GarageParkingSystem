package ProjectPackage;

public class DisplayAvailableSlots {
    public static void DisplayAvSlots(Slot sl[] , int slotsnum) {
		System.out.println("******************************");
		System.out.println("*       Available Slots      *");
		System.out.println("******************************");
		for(int i = 0 ; i<slotsnum ; i++) {
			if(sl[i].statues == true) {
				System.out.println("Slot Number : "+sl[i].SlotNum);
				System.out.println("Width : "+sl[i].getWidth());
				System.out.println("Depth : "+sl[i].getDepth());
				System.out.println("------------------------------");
			}
		}
	}
}
