public class ArtsStudent extends Student{

    private String major;
    private String minor;

    ArtsStudent(String scanner){
        ArtsStudent student = new ArtsStudent();
        String thing[] = scanner.split(",");
        this.degree = "Arts";
        switch (thing.length){
            case 2:
                this.setFamilyName(thing[1]);
                break;
            case 6:
                this.setStudentID(thing[1]);
                this.setFamilyName(thing[2]);
                this.setGivenName(thing[3]);
                this.minor = thing[5];
                this.major = thing[4];
                break;
        }
    }

    public String getMajor() {
        return major;
    }

    public String getMinor() {
        return minor;
    }

    public ArtsStudent() {

    }
    public String writeRecord(){
        return "Academic record for " + this.getGivenName() + " " + this.getFamilyName() + "(" + this.getStudentID() + ")" + '\n'
                + "Degree: " + this.degree + '\n'
                + "Major: " + this.getMajor() + '\n'
                + "Minor: " + this.getMinor() + '\n'
                + this.writeResults();
    }
}
