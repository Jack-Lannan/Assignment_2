import java.util.*;

public class StudentDatabase implements Constants{
    private List<Student> db = new LinkedList<>();
    private int studentCount = NUMBER_OF_STUDENTS;

    StudentDatabase(){
    }

    StudentDatabase(Integer value){
    }

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

    public LinkedList<MedStudent> getMeds(){
        LinkedList<MedStudent> medStudents = new LinkedList<>();
        for (Student student:db) {
            if (student.degree == "Medicine") {
                medStudents.add((MedStudent)student);
            }
        }
        return medStudents;
    }

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