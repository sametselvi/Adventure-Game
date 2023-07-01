import java.util.ArrayList;
import java.util.List;

public class Award {
    private String name;
    private int id;
    private List<Award> inventory;
    private List<Award> awards;
    private boolean cleared;


    public List<Award> getInventory() {

        return inventory;
    }

    public void setInventory(List<Award> inventory) {
        this.inventory = inventory;
    }

    public static Award[] awards() {
        Award[] awardsList = new Award[5];
        awardsList[0] = new Award("Food", 1);
        awardsList[1] = new Award("Firewood", 2);
        awardsList[2] = new Award("Water", 3);
        awardsList[3] = new Award("Money", 4);
        awardsList[4] = new Award("Nothing :(", 5);


        return awardsList;
    }

    public static Award getAwardByID(int id) {
        for (Award a : Award.awards()) {
            if (a.getId() == id) {
                return a;
            }

        }

        return null;
    }public Award(){
        this.cleared= false;

        awards= new ArrayList<>();

    }
    public void addReward(Award award) {
        awards.add(award);
    }
    public boolean hasAllAwards(List<Award> allAwards) {
        return awards.containsAll(allAwards);
    }





    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Award(String name, int id) {
        this.name = name;
        this.id = id;


    } public void clearZone(Inventory playerInventory) {
        if (!cleared) {

            cleared = true;
        }

    }    public boolean isCleared() {
        return cleared;
    }


}
