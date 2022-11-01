import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class KiemTraSDT {
	public static boolean ktPhone(String txt) {
        String regx = "\\d{3}\\d{7}";
		Pattern pattern = Pattern.compile(regx,Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(txt);
		return matcher.find();
    }
	
	public static void main(String[] args) {
		boolean flag;
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		
		if (ktPhone(input)) {
			System.out.println("OK");
		} else {
			System.out.println("No");
		}
	}
}