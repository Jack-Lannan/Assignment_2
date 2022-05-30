import java.util.*;

public class StudentDatabase implements Constants{

    private List<Student> db = new LinkedList<>();
    private int studentCount = NUMBER_OF_STUDENTS;

    StudentDatabase(){
    }

    StudentDatabase(Integer value){
    }

    // getter for the DB
    public List<Student> getDb() {
        return db;
    }

    // Add the student from input. Characterises them into Science, Medicine or Art.
    public void addStudent(String student){
        switch (student.charAt(0)){
            case 'S':
                db.add(new Student(student));
                studentCount++;
                break;
            case 'M':
                db.add(new MedStudent(student));
                studentCount++;
                break;
            case'A':
                db.add(new ArtsStudent(student));
                studentCount++;
                break;
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
        Prize prize = new Prize(one+','+two + ','+three);
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