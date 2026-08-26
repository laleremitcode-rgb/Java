import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
public class EmployeeExperience {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();
        System.out.print("Enter joining date (dd-MM-yyyy): ");
        String inputDate = scanner.nextLine();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate joiningDate = LocalDate.parse(inputDate, formatter);
        LocalDate today = LocalDate.now();
        Period period = Period.between(joiningDate, today);
        System.out.println("\nEmployee Details:");
        System.out.println("Name: " + name);
        System.out.println("Joining Date: " + joiningDate.format(formatter));
        System.out.println("Total Experience: " + period.getYears() + " years, " 
                           + period.getMonths() + " months, and " 
                           + period.getDays() + " days.");
        scanner.close();
    }
}