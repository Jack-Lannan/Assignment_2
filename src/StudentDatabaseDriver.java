import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StudentDatabaseDriver {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        Scanner fileScanner;
        StudentDatabase studentDatabase = new StudentDatabase();
        try{
            fileScanner = new Scanner(new FileInputStream("data" + File.separator + fileName));
            while(fileScanner.hasNext()){
                String nextLine = fileScanner.nextLine();
                switch (nextLine.charAt(0)){
                    case 'S':
                    case 'M':
                    case 'A':
                        studentDatabase.addStudent(nextLine);
                        String student[] = nextLine.split(",");
                        break;
                    case 'R':
                        //need the database to be working for this stage, access the student by their id
                        //add the given result to their corresponding result array that they would have
                        //database.findStudent(String their id)
                        //database.addResult(String of the given result field)
                        String results[] = nextLine.split(",");
                        studentDatabase.findStudent(results[1]).addResult(nextLine);
//                        System.out.println(studentDatabase.findStudent(results[1]).writeRecord());
                        break;
                    case 'P':
                        Prize prize = new Prize(nextLine);
                        prize.awardPrize(studentDatabase);
                }
            }
            studentDatabase.printRecords();
        }catch (FileNotFoundException ex){
            System.out.println(fileName + " not found!");
        }
    }
}