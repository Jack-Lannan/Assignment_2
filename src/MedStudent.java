import java.util.Arrays;

public class MedStudent extends Student{
    String prizes[] = new String[10];
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
                this.prizes[0] = thing[4];
                break;
        }
    }

    public void addPrize(String prize){
        this.prizes[prizes.length] = prize;
    }

    public String[] getPrizes() {
        return prizes;
    }

    public String writeRecord(){
        String concatenator = "";
        for (int i = 0; i < prizes.length; i++) {
            if (prizes[i] != null){
                concatenator += prizes[i] + '\n';
            }
        }
        return "Academic record for " + this.getGivenName() + " " + this.getFamilyName() + "(" + this.getStudentID() + ")" + '\n'
                + "Degree: " + this.degree + '\n'
                + "Prize: " + concatenator
                + this.writeResults();
    }
}
