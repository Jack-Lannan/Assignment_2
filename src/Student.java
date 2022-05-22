import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class Student implements Constants{
    private String studentID;
    private String familyName;
    private String givenName;
    protected String degree;
    private Result results[] = new Result[NUMBER_OF_TOPICS];

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    private int topicCount = 0;
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
                topicCount++;
                return;
            }
        }
    }
    public Result[] getResults() {
        return results;
    }

    public int[] getResult(String degree){
        String split[] = degree.split(",");
        int finList[] = new int[0];
        LinkedList<Integer> thing = new LinkedList<>();
        for (int i = 0; i< results.length;i++){
            Collections.sort(thing);
            if (results[i] != null){
                if (results[i].getCode().contains(degree)){
                    if (thing.size() == Integer.parseInt(split[1]))
                        thing.remove(0);
                    thing.add(results[i].getMark());
                }
            }
        }
        for (int i = 0; i < thing.size();i++){
            finList[i] = thing.get(i);
        }
        return finList;
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
