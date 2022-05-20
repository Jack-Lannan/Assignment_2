import java.util.Arrays;
import java.util.LinkedList;

public class MedStudent extends Student{
    LinkedList<String> prizes = new LinkedList<>();
    MedStudent(String scanner){
        String thing[] = scanner.split(",");
        switch (thing.length){
            case 1:
                this.setFamilyName(thing[2]);
                break;
            case 5:
                this.setStudentID(thing[1]);
                this.setFamilyName(thing[2]);
                this.setGivenName(thing[3]);
                this.degree = "Medicine";
                this.prizes.add(thing[4]);
                break;
        }
    }

    public void addPrize(String prize){
        this.prizes.add(prize);
    }

    public LinkedList<String> getPrizes() {
        return prizes;
    }

    public String writeRecord(){
        String concatenator = "";
        for (int i = 0; i < prizes.size(); i++) {
                concatenator += prizes.get(i) + '\n';
        }
        return "Academic record for " + this.getGivenName() + " " + this.getFamilyName() + "(" + this.getStudentID() + ")" + '\n'
                + "Degree: " + this.degree + '\n'
                + "Prize: " + concatenator
                + this.writeResults();
    }
}
