import java.sql.*;
import java.util.Scanner;

public class EmployeeDBApp {

    // MySQL DB credentials
    static final String DB_URL = "jdbc:mysql://localhost:3306/employee_db";
    static final String USER = "root"; // change if needed
    static final String PASS = "your_password"; // change your DB password

    static Connection conn;
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected to DB!");

        
            System.out.println("\n==============================");
            System.out.println("Task 7 : Employee Database App");
            System.out.println("By Aanchal Srivastav");
            System.out.println("==============================\n");

            while (true) {
                System.out.println("===== Employee DB Menu =====");
                System.out.println("1. Add Employee");
                System.out.println("2. View Employees");
                System.out.println("3. Update Employee");
                System.out.println("4. Delete Employee");
                System.out.println("5. Exit");
                System.out.print("Choose: ");

                int choice = sc.nextInt();
                switch (choice) {
                    case 1: addEmployee(); break;
                    case 2: viewEmployees(); break;
                    case 3: updateEmployee(); break;
                    case 4: deleteEmployee(); break;
                    case 5: System.exit(0);
                    default: System.out.println("Invalid choice.");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static void addEmployee() throws SQLException {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter position: ");
        String position = sc.next();
        System.out.print("Enter salary: ");
        double salary = sc.nextDouble();

        String sql = "INSERT INTO employees (name, position, salary) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, name);
        ps.setString(2, position);
        ps.setDouble(3, salary);
        ps.executeUpdate();

        System.out.println("Employee added!");
    }

    static void viewEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        System.out.println("\n--- Employee List ---");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") +
                               ", Name: " + rs.getString("name") +
                               ", Position: " + rs.getString("position") +
                               ", Salary: " + rs.getDouble("salary"));
        }
    }

    static void updateEmployee() throws SQLException {
        System.out.print("Enter employee ID to update: ");
        int id = sc.nextInt();
        System.out.print("Enter new salary: ");
        double salary = sc.nextDouble();

        String sql = "UPDATE employees SET salary = ? WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDouble(1, salary);
        ps.setInt(2, id);
        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Employee updated!");
        else
            System.out.println("Employee not found.");
    }

    static void deleteEmployee() throws SQLException {
        System.out.print("Enter employee ID to delete: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM employees WHERE id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setInt(1, id);
        int rows = ps.executeUpdate();

        if (rows > 0)
            System.out.println("Employee deleted!");
        else
            System.out.println("Employee not found.");
    }
                               }
