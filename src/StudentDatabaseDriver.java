import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
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
            try{
                File myObj = new File("data/output/databaseOutput.txt");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                } else {
                    System.out.println("File already exists.");
                }
                FileWriter mywriter = new FileWriter("data/output/filename.txt");
                Files.writeString(Path.of("output/filename.txt"),studentDatabase.printcharRecords());
                mywriter.close();
                System.out.println(Files.readString(Path.of("data/output/filename.txt")));
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }catch (FileNotFoundException ex){
            System.out.println(fileName + " not found!");
        }
    }
}
