import java.util.Arrays;
import java.util.LinkedList;

public class Prize implements Constants{
    private String name;
    private String template;
    private int topicsRequired;

    Prize(String prize){
        String[] prizes = prize.split(",");
        name = prizes[1];
        template = prizes[2];
        topicsRequired = Integer.parseInt(prizes[3]);
    }

    public void awardPrize(StudentDatabase studentDatabase){
        MedStudent medStudent = null;
        LinkedList<MedStudent> meds = studentDatabase.getMeds();
        for (int i = 0;i<meds.size(); i++){
            if (meds.get(i).getResults().length >= topicsRequired){
                if(meds.get(i).getResult(template + ',' + topicsRequired) != null ){
                    if (Arrays.stream(meds.get(i).getResult(template + ',' + topicsRequired)).sum() != 0){
                        if (medStudent == null) {
                            medStudent = meds.get(i);
                        }
                        int total = Arrays.stream(meds.get(i).getResult(template + ',' + topicsRequired)).sum();
                        if (total/topicsRequired > Arrays.stream(medStudent.getResult(template + ',' + topicsRequired)).sum()/topicsRequired && total >= 0){
                            medStudent = meds.get(i);
                        }
                    }
                }
            }
        }
        if (medStudent != null)
            if (medStudent.prizes.size() < NUMBER_OF_PRIZES ){
                medStudent.addPrize(name);
            }
    }
}
