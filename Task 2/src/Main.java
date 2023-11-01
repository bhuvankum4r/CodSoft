import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----SGPA Calculator-----");
        for (int i = 0; i < Student.Credits.length; i++) {
            // Input data into Student arrays
            System.out.println("Course " + (i + 1) + " :");
            System.out.print("Name: ");
            Student.Courses[i] = scanner.next();
            System.out.print("Credits: ");
            Student.Credits[i] = scanner.nextInt();
            System.out.print("Internals: ");
            Student.Internals[i] = scanner.nextInt();
            if (Student.Internals[i] > 50) {
                System.out.println("Error !");
                break;
            }
            System.out.print("Externals: ");
            Student.Externals[i] = scanner.nextInt();
            if (Student.Externals[i] > 100) {
                System.out.println("Error !");
                break;
            }
            System.out.println();
        }

        // Create an instance of the Calculate class to perform calculations
        Calculate calculator = new Calculate();
    }
}
