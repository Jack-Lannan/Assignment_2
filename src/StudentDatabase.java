import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class StudentDatabase implements Constants{

    private List<Student> db = new LinkedList<>();
    private int studentCount = NUMBER_OF_STUDENTS;

    StudentDatabase(){
    }

    public void insertFile(String filename, StudentDatabase studentDatabase){
        Scanner fileScanner;
        try{
            fileScanner = new Scanner(new FileInputStream("data" + File.separator + filename));
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
            case 'S':
                db.add(new Student(student));
                studentCount++;
                break;
            case 'M':
                db.add(new MedStudent(student));
                studentCount++;
                break;
            case 'A':
                db.add(new ArtsStudent(student));
                studentCount++;
                break;
        }
        }
    }

    // Finds student using StudentID.
    public Student findStudent(String student){
        for (int i = 0; i < db.size(); i++){
                if ( db.get(i).getStudentID() != null && db.get(i).getStudentID().equals(student)){
                    return db.get(i);
                }
        }
        return null;
    }
    public void addResult(String results){
        String resultSection[]  = results.split(",");
        for (int i = 0; i< db.size(); i++){
            if (db.get(i).getStudentID() == resultSection[1]){
                db.get(i).addResult(results);
            }
        }
    }

    public void awardPrize(String one, String two, int three){
        Prize prize = new Prize("P," + one + ',' + two + ',' + three);
        prize.awardPrize(this);
    }

    // Returns a list of students studying Medicine.
    public LinkedList<MedStudent> getMeds(){
        LinkedList<MedStudent> medStudents = new LinkedList<>();
        for (Student student:db) {
            if (student.degree == "Medicine") {
                medStudents.add((MedStudent)student);
            }
        }
        return medStudents;
    }

    // Prints every student's record.
    public void printRecords(){
        for (int i = 0; i< db.size();i++){
            System.out.println(db.get(i).writeRecord());
        }
    }

    public String printcharRecords(){
        String thing = "";
        for (int i = 0; i< db.size();i++){
            thing += db.get(i).writeRecord();
            thing +="\n";
        }
        return thing;
    }

    public void clearRecords(){
        db.clear();
        this.studentCount = 0;
    }



}