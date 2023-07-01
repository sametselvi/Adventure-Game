public class SafeHouse extends NormalLoc {

    public SafeHouse(Player player) {
        super(1, player, "Güvenli Ev");
    }

    @Override

    public boolean onLocation() {
        GameChar samurai = new Samurai();
        GameChar archer = new Archer();
        GameChar knight = new Knight();


        System.out.println("You are in the Safe House !!");

        if (getPlayer().getHealth() < 0) {
            System.out.println("You have died. Your life cannot be restored.");

        } else {

            for (int i = 0; i < this.getPlayer().getInventory().getRewards().size(); i++) {
                if (this.getPlayer().getInventory().getRewards().get(i).equals("Food")) {
                    for (int j = 0; j < this.getPlayer().getInventory().getRewards().size(); j++) {
                        if (this.getPlayer().getInventory().getRewards().get(j).equals("Firewood")) {
                            for (int k = 0; k < this.getPlayer().getInventory().getRewards().size(); k++) {
                                if (this.getPlayer().getInventory().getRewards().get(k).equals("Water")) {

                                    for(int t =0; t<this.getPlayer().getInventory().getRewards().size(); t++){
                                        if(this.getPlayer().getInventory().getRewards().get(t).equals("Reward")){
                                            System.out.println("You have completed the game successfully. Congratulations !!");
                                            return false;
                                        }
                                    }


                                }

                            }
                        }
                    }
                }


            }







            if (samurai.getId() == 1) {
                int healthSamurai = 21;
                this.getPlayer().setHealth(healthSamurai);

            } else if (archer.getId() == 2) {
                this.getPlayer().setHealth(18);


            } else if (knight.getId() == 3) {
                this.getPlayer().setHealth(24);

            }
        }


        System.out.println("Your health is being restored to full.! !!");

        System.out.println("Your new health is : " + getPlayer().getHealth());
        return true;
    }
}
