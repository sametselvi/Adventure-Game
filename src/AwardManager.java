import  java.util.List;
import java.util.ArrayList;

public class AwardManager {


    private List<Award> awards;

    public AwardManager(){
        this.awards =new ArrayList<>();



    }
    public void addAward(Award award){
        awards.add(award);
    }

    public boolean hasEarnedAward(Inventory inventory, Award award){
        return true;

    }
}
