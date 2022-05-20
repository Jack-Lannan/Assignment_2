import java.util.Arrays;
import java.util.LinkedList;

public class Prize {
    private String name;
    private String template;
    private int topicsRequired;

    Prize(String prize){
        String prizes[] = prize.split(",");
        name = prizes[1];
        template = prizes[2];
        topicsRequired = Integer.parseInt(prizes[3]);
    }

    public void awardPrize(StudentDatabase studentDatabase){
        MedStudent medStudent = null;
        LinkedList<MedStudent> meds = studentDatabase.getMeds();

        for (int i = 0;i<meds.size(); i++){
            if (meds.get(i).getResults().length >= topicsRequired){
                if(meds.get(i).getResult(template + ',' + topicsRequired) != null){
                    if (medStudent == null) {
                        medStudent = meds.get(i);
                    }
                    if (Arrays.stream(meds.get(i).getResult(template + ',' + topicsRequired)).sum()/topicsRequired > Arrays.stream(medStudent.getResult(template + ',' + topicsRequired)).sum()/3){
                        medStudent = meds.get(i);
                    }
                }
            }
        }
        System.out.println(medStudent.writeRecord());
        medStudent.addPrize(name);
    }
}
