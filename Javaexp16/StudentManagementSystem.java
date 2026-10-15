import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentManagementSystem {

    private static final String URL = "jdbc:mysql://localhost:3306/studentdb?createDatabaseIfNotExist=true&useSSL=false&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Blank password

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        createTableIfNotExists();

        while (true) {
            System.out.println("\n================ STUDENT MANAGEMENT SYSTEM ================");
            System.out.println("1. Insert a Student Record");
            System.out.println("2. Display Students with Percentage > 70");
            System.out.println("3. Update Student Percentage");
            System.out.println("4. Delete Student Record by Roll No");
            System.out.println("5. Display All Student Records");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            if (!scanner.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                scanner.next();
                continue;
            }

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> insertStudent(scanner);
                case 2 -> displayHighScorers();
                case 3 -> updatePercentage(scanner);
                case 4 -> deleteStudent(scanner);
                case 5 -> displayAllStudents();
                case 6 -> {
                    System.out.println("Exiting application. Goodbye!");
                    scanner.close();
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice! Select between 1 and 6.");
            }
        }
    }

    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private static void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS Student ("
                   + "roll_no INT PRIMARY KEY, "
                   + "name VARCHAR(50), "
                   + "percentage DOUBLE)";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement()) {
            stmt.executeUpdate(sql);
            System.out.println("Connected to MySQL successfully with empty password.");
        } catch (SQLException e) {
            System.err.println("Database Connection Error: " + e.getMessage());
        }
    }

    private static void insertStudent(Scanner scanner) {
        System.out.print("Enter Roll No: ");
        int rollNo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Percentage: ");
        double percentage = scanner.nextDouble();

        String sql = "INSERT INTO Student (roll_no, name, percentage) VALUES (?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, rollNo);
            pstmt.setString(2, name);
            pstmt.setDouble(3, percentage);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("Record inserted successfully!");
            }
        } catch (SQLException e) {
            System.err.println("Error inserting record: " + e.getMessage());
        }
    }

    private static void displayHighScorers() {
        String sql = "SELECT roll_no, name, percentage FROM Student WHERE percentage > 70";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n--- Students with Percentage > 70% ---");
            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("Roll No: %-5d | Name: %-20s | Percentage: %.2f%%\n",
                        rs.getInt("roll_no"), rs.getString("name"), rs.getDouble("percentage"));
            }
            if (!found) System.out.println("No students found.");
        } catch (SQLException e) {
            System.err.println("Error fetching records: " + e.getMessage());
        }
    }

    private static void updatePercentage(Scanner scanner) {
        System.out.print("Enter Roll No to update: ");
        int rollNo = scanner.nextInt();

        System.out.print("Enter New Percentage: ");
        double newPercentage = scanner.nextDouble();

        String sql = "UPDATE Student SET percentage = ? WHERE roll_no = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDouble(1, newPercentage);
            pstmt.setInt(2, rollNo);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("Percentage updated successfully!");
            } else {
                System.out.println("Roll No not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error updating record: " + e.getMessage());
        }
    }

    private static void deleteStudent(Scanner scanner) {
        System.out.print("Enter Roll No to delete: ");
        int rollNo = scanner.nextInt();

        String sql = "DELETE FROM Student WHERE roll_no = ?";

        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, rollNo);

            if (pstmt.executeUpdate() > 0) {
                System.out.println("Student record deleted successfully!");
            } else {
                System.out.println("Roll No not found.");
            }
        } catch (SQLException e) {
            System.err.println("Error deleting record: " + e.getMessage());
        }
    }

    private static void displayAllStudents() {
        String sql = "SELECT * FROM Student";

        try (Connection conn = getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("\n-------------------------------------------------");
            System.out.printf("%-10s %-20s %-10s\n", "Roll No", "Name", "Percentage");
            System.out.println("-------------------------------------------------");

            boolean found = false;
            while (rs.next()) {
                found = true;
                System.out.printf("%-10d %-20s %-10.2f\n",
                        rs.getInt("roll_no"), rs.getString("name"), rs.getDouble("percentage"));
            }
            if (!found) System.out.println("No records found.");
            System.out.println("-------------------------------------------------");

        } catch (SQLException e) {
            System.err.println("Error fetching records: " + e.getMessage());
        }
    }
}