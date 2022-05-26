import java.util.ArrayList;
import java.util.List;

public class MedStudent extends Student{
    List<String> prizes = new ArrayList<>();
    int prizeCount;

    MedStudent(String scanner){
        String thing[] = scanner.split(",");
        switch (thing.length){
            case 1:
                this.setFamilyName(thing[0]);
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
        this.prizes.add(prize);
    }

    public List<String> getPrizes() {
        return prizes;
    }

    public String writeRecord () {
        String concatenate = "";
        for (int i = 0; i < prizes.size(); i++) {
            if (prizes.get(i) != null) {
            concatenate += prizes.get(i) + '\n';
            }
        }

        return "Academic record for " + this.getGivenName() + " " + this.getFamilyName() + "(" + this.getStudentID() + ")" + '\n'
                + "Degree: " + this.degree + '\n'
                + "Prize: " + concatenate
                + this.writeResults();
        }
    }
