public class Result
{

    private String code;
    private String grade;
    private int mark;

    Result(String scanner){
        String sections[] = scanner.split(",");
        this.code = sections[2];
        if (sections.length > 4)
            this.mark = Integer.parseInt(sections[4]);
        else
            this.mark = -1;
        this.grade = sections[3];
    }

    public String write(){
        if (this.getMark() >= 0)
            return this.getCode() + " " + this.getGrade() + " " + this.getMark() + '\n';
        return this.getCode() + " " + this.getGrade() + '\n';
    }

    public String getCode() {
        return code;
    }

    public String getGrade() {
        return grade;
    }

    public int getMark() {
        return mark;
    }
}
