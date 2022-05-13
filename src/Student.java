import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Student {
    private String studentID;
    private String familyName;
    private String givenName;
    protected String degree;
    private Result[] results;
    private int topicCount;
    private 

    Student(){

    }

    Student(String scanner){
        String thing[] = scanner.split(",");
        this.studentID = thing[1];
        this.familyName = thing[2];
        this.givenName = thing[3];
        this.degree = "Science";
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFamilyName() {
        return familyName;
    }

    public String getGivenName() {
        return givenName;
    }

    public Result[] getResults() {
        return results;
    }

    public int getTopicCount() {
        return topicCount;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", familyName='" + familyName + '\'' +
                ", givenName='" + givenName + '\'' +
                ", degree='" + degree + '\'' +
                ", results=" + Arrays.toString(results) +
                ", topicCount=" + topicCount +
                '}';
    }

    public void readInFile(String fileName){
        Student student;
        Scanner fileScanner;

        try{
            fileScanner = new Scanner(new FileInputStream("data" + File.separator + fileName));
            while(fileScanner.hasNext()){
                String nextLine = fileScanner.nextLine();
                student= new Student(nextLine);
            }
        }catch (FileNotFoundException ex){
            System.out.println(fileName + " not found!");
        }
    }
}
