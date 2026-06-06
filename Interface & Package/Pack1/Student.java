package Pack1;
import java.util.Scanner;
public class Student extends Hostel implements Department
{
    private String studentName, regNo, electiveSubject, depName, depHead;
    private double avgMarks;
    public void getDeptData()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Dept Name: "); depName = sc.nextLine();
        System.out.print("Enter Dept Head: "); depHead = sc.nextLine();
    }
    public void printDeptData()
    {
        System.out.println("Dept: " + depName + " | Head: " + depHead);
    }
    public void getStudentData()
    {
        Scanner sc = new Scanner(System.in);
        getHostelData();
        getDeptData();
        System.out.print("Enter Student Name: "); studentName = sc.nextLine();
        System.out.print("Enter Reg No: "); regNo = sc.nextLine();
        System.out.print("Enter Elective: "); electiveSubject = sc.nextLine();
        System.out.print("Enter Avg Marks: "); avgMarks = sc.nextDouble();
    }
    public void printStudentData()
    {
        System.out.println("\n--- STUDENT RECORD ---");
        System.out.println("Name: " + studentName + " | RegNo: " + regNo);
        printHostelData();
        printDeptData();
        System.out.println("Elective: " + electiveSubject + " | Avg Marks: " + avgMarks);
    }
}
