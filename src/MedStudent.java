import java.util.ArrayList;
import java.util.List;

public class MedStudent extends Student{
    List<String> prizes = new ArrayList<>();
    int prizeCount;
    //Medical student constructor as per the data file insertion format
    MedStudent(String scanner){
        String thing[] = scanner.split(",");
        this.degree = "Medicine";
        switch (thing.length){
            case 4:
                this.setStudentID(thing[1]);
                this.setFamilyName(thing[2]);
                this.setGivenName(thing[3]);
                break;
        }
        if (thing.length>= 5){
            this.setStudentID(thing[1]);
            this.setFamilyName(thing[2]);
            this.setGivenName(thing[3]);
            for (int i = 4; i < thing.length; i++) {
                this.prizes.add(thing[i]);
            }
        }
        prizeCount =prizes.size();
    }

    public void addPrize(String prize){
        this.prizes.add(prize);
    }

    public List<String> getPrizes() {
        return prizes;
    }
    //writes the students record as per the specification given
    public String writeRecord () {
        String concatenate = "";
        if (prizes.size() == 0)
            concatenate = "\n";
        for (int i = 0; i < prizes.size(); i++) {
            if (i == 0)
                concatenate = prizes.get(i);
            else if (prizes.get(i) != null) {
            concatenate += '\n' + "Prize: " + prizes.get(i) ;
            }
        }

        return "Academic record for " + this.getGivenName() + " " + this.getFamilyName() + "(" + this.getStudentID() + ")" + '\n'
                + "Degree: " + this.degree + '\n'
                + "Prize: " + concatenate
                + this.writeResults() + '\n';
        }
    }
