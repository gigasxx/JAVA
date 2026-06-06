package Pack1;
import java.util.Scanner;
public class Hostel
{
    protected String hostelName, hostelLocation;
    protected int noOfRooms;
    public void getHostelData()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Hostel Name: "); hostelName = sc.nextLine();
        System.out.print("Enter Location: "); hostelLocation = sc.nextLine();
        System.out.print("Enter No of Rooms: "); noOfRooms = sc.nextInt();
    }
    public void printHostelData()
    {
        System.out.println("Hostel: " + hostelName + " | Location: " + hostelLocation);
    }
}
