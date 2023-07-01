public class Cave extends BattleLoc{

    private boolean cleared;
    private String reward;

    public Cave( Player player){
        super(3,player, "Cave" ,new Zombie(),"food",3);

        cleared = false;


    }


}
