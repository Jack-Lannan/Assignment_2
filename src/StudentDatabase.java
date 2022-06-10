import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class StudentDatabase implements Constants{

    private final List<Student> db = new LinkedList<>();
    private int studentCount = NUMBER_OF_STUDENTS;

    StudentDatabase(){
    }

    public void insertFile(String filename, StudentDatabase studentDatabase){
        Scanner fileScanner;
        try{
            fileScanner = new Scanner(new FileInputStream("data" + File.separator + filename));
            while(fileScanner.hasNext()){
                String nextLine = fileScanner.nextLine();
                switch (nextLine.charAt(0)) {
                    case 'S', 'M', 'A' -> studentDatabase.addStudent(nextLine);
                    case 'R' -> {
                        //need the database to be working for this stage, access the student by their id
                        //add the given result to their corresponding result array that they would have
                        //database.findStudent(String their id)
                        //database.addResult(String of the given result field)
                        String[] results = nextLine.split(",");
                        studentDatabase.findStudent(results[1]).addResult(nextLine);
                    }
//                        System.out.println(studentDatabase.findStudent(results[1]).writeRecord());
                    case 'P' -> {
                        Prize prize = new Prize(nextLine);
                        prize.awardPrize(studentDatabase);
                    }
                }
            }
            studentDatabase.printRecords();
        }catch (FileNotFoundException ex){
            System.out.println(filename + " not found!");
        }
    }

    // getter for the DB
    public List<Student> getDb() {
        return db;
    }

    // Add the student from input. Characterises them into Science, Medicine or Art.
    public void addStudent(String student){
        if (db.size() < studentCount){

            switch (student.charAt(0)) {
                case 'S' -> {
                    db.add(new Student(student));
                    studentCount++;
                }
                case 'M' -> {
                    db.add(new MedStudent(student));
                    studentCount++;
                }
                case 'A' -> {
                    db.add(new ArtsStudent(student));
                    studentCount++;
                }
            }
        }
        writeToFile(this);
    }

    // Finds student using StudentID.
    public Student findStudent(String student){
        for (Student value : db) {
            if (value.getStudentID() != null && value.getStudentID().equals(student)) {
                return value;
            }
        }
        return null;
    }

    //used to award prizes from the student database class
    //writes the changes to the output document
    public void awardPrize(String one, String two, int three){
        Prize prize = new Prize("P, " + one+','+two + ','+three);
        prize.awardPrize(this);
        writeToFile(this);
    }

    // Returns a list of students studying Medicine.
    public LinkedList<MedStudent> getMeds(){
        LinkedList<MedStudent> medStudents = new LinkedList<>();
        for (Student student:db) {
            if (student.degree.equals("Medicine")) {
                medStudents.add((MedStudent)student);
            }
        }
        return medStudents;
    }

    //return all Arts students in the database
    public ArtsStudent findArts(String id){
        for (Student student:db) {
            if (student.degree.equals("Arts") && student.getStudentID().equals(id))
                return (ArtsStudent) student;
        }
        return null;
    }

    // Prints every student's record.
    public void printRecords() {
        for (Student student : db) {
            System.out.println(student.writeRecord());
        }
    }
    public String recordString(){
        StringBuilder result = new StringBuilder();
        for (Student student : db) {
            result.append(student.writeRecord()).append('\n');
        }
        return result.toString();
    }
    public String printcharRecords(){
        StringBuilder thing = new StringBuilder();
        for (Student student : db) {
            thing.append(student.writeRecord());
            thing.append("\n");
        }
        return thing.toString();
    }
    //clear student database of all records
    public void clearRecords(){
        db.clear();
        this.studentCount = 0;
    }
    //writes to the output file in data/output directory
    public void writeToFile(StudentDatabase studentDatabase){
        try{
            FileWriter mywriter = new FileWriter("data/output/databaseOutput.txt");
            Files.writeString(Path.of("data/output/databaseOutput.txt"),studentDatabase.printcharRecords());
            mywriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}