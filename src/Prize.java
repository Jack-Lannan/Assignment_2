import java.util.Arrays;
import java.util.LinkedList;

public class Prize implements Constants{
    private String name;
    private String template;
    private int topicsRequired;
    //prize constructor as per the data file insertion format
    Prize(String prize){
        String[] prizes = prize.split(",");
        this.name = prizes[1];
        this.template = prizes[2];
        this.topicsRequired = Integer.parseInt(prizes[3]);
    }

    //determines which medical student wins the prize, based on who has the highest average mark across
    //their given topics
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
