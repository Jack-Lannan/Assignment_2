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

    }
}
