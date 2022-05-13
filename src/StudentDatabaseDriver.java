import java.util.Scanner;

public class StudentDatabaseDriver {


    public static void main(String[] args) {
        Student student = new Student();
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        student.readInFile(fileName);
        System.out.println(student);
    }
}
