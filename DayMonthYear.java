import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DayMonthYear {

	public static void main(String[] args) {
		Scanner key = new Scanner(System.in);
		Date a = null;
		Date b = null;
		SimpleDateFormat sc = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			System.out.print("Enter Date: ");
			a = sc.parse(key.nextLine());
			System.out.print("Enter Date: ");
			b = sc.parse(key.nextLine());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long getDiff = b.getTime() - a.getTime();
		long getDaysDiff = getDiff / (24 * 60 * 60 * 1000);
		
		System.out.println("Date: " + sc.format(a));
		System.out.println("Date: " + sc.format(b));
		System.out.println("Day: " + getDaysDiff);
	}

}
