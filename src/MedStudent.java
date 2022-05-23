import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedStudent extends Student{
    List<String> prizes = new ArrayList<>();
    int prizeCount;
    MedStudent(String scanner){
        String thing[] = scanner.split(",");
        switch (thing.length){
            case 1:
                this.setFamilyName(thing[1]);
                break;
            case 5:
                this.setStudentID(thing[1]);
                this.setFamilyName(thing[2]);
                this.setGivenName(thing[3]);
                this.degree = "Medicine";
                this.prizes.add(thing[4]);
                prizeCount=1;
                break;
        }
    }

    public void addPrize(String prize){
        if(prizeCount<10) {
            this.prizes.add(prize);
            prizeCount++;
        }
    }

    public List<String> getPrizes() {
        return this.prizes;
    }

    public String writeRecord(){
        String concatenator = "";
        for (int i = 0; i < prizes.size(); i++) {
            if (prizes.get(i) != null){
                concatenator += prizes.get(i) + '\n';
            }
        }
        return "Academic record for " + this.getGivenName() + " " + this.getFamilyName() + "(" + this.getStudentID() + ")" + '\n'
                + "Degree: " + this.degree + '\n'
                + "Prize: " + concatenator
                + this.writeResults();
    }
}
