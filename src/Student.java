import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Student {
    private String studentID;
    private String familyName;
    private String givenName;
    protected String degree;
    private Result[] results = new Result[24];

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    private int topicCount;
    private Map<String,Student> studentMap = new TreeMap<>();

    Student(String scanner){
        String thing[] = scanner.split(",");
        switch (thing.length){
            case 1:
                this.familyName = thing[0];
                break;
            case 4:
                this.studentID = thing[1];
                this.familyName = thing[2];
                this.givenName = thing[3];
                this.degree = "Science";
                studentMap.put(this.familyName, this);
                break;
        }

    }

    public Student() {
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFamilyName() {
        return familyName;
    }
    public String getFamilyName(String familyname) {
        return studentMap.get(familyname).familyName;
    }

    public String getGivenName() {
        return givenName;
    }
    public String getGivenName(String familyname) {
        return studentMap.get(familyname).givenName;
    }

    public void addResult(String scanner) {
        Result result = new Result(scanner);
        for (int i = 0; i < 24; i++) {
            if (results[i] == null) {
                results[i] = result;
                return;
            }
        }
    }
    public Result[] getResults() {
        return results;
    }

    public String writeResults(){
        String returner = "";
        int i = 0;
        while (i< 24 && results[i] != null){
            returner += results[i].write();
            i++;
        }
        return returner;
    }

    public int getTopicCount() {
        return topicCount;
    }

    public String writeHeader(){
        return null;
    }

    public String writeRecord(){
        return "Academic record for " + this.getGivenName() + " " + this.getFamilyName() + "(" + this.getStudentID() + ")" + '\n'
                + "Degree: " + this.degree + '\n'
                + this.writeResults();
    }

    @Override
    public String toString() {
        return studentMap.toString();
    }
}
