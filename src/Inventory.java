import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private Weapon weapon;
    private Armor armor;
    private Award award;
    private List<String> rewards; // Ödüllerin listesi
    private boolean cleared;





    public Award getAward() {


        return award;


    }

    public void addReward(String reward) {
        rewards.add(reward);
    }





    public void setAward(Award award) {
        this.award = award;
    }

    public List<String> getRewards() {
        return rewards;
    }



    public void setRewards(List<String> rewards) {
        this.rewards = rewards;
    }

  /*  public boolean hasAllRewards(List<String> allRewards) {
        return inventory.containsAll(allRewards);
    }


   */
    public Inventory() {
        this.weapon = new Weapon("Fist", -1, 0, 0);
        this.armor = new Armor("Body", -1, 0, 0);
        this.award = new Award("Hungry", -1);
        rewards = new ArrayList<>();
        this.cleared= false;



    }



    public void clearZone(Inventory playerInventory) {
        if (!cleared) {


            cleared = true;
        }

    }    public boolean isCleared() {
        return cleared;
    }




    public Weapon getWeapon() {

        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armor getArmor() {
        return armor;
    }

    public void setArmor(Armor armor) {

        this.armor = armor;
    }




}