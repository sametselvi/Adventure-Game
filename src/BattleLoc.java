import java.util.Random;

public abstract class BattleLoc extends Location {


    private Obstacle obstacle;
    private String award;
    private int maxObstacle;

    public boolean isShow = false;

    public BattleLoc(int id, Player player, String name, Obstacle obstacle, String award, int maxObstacle) {

        super(id, player, name);
        this.obstacle = obstacle;
        this.maxObstacle = maxObstacle;
        this.award = award;
    }


    Award awardFood = Award.getAwardByID(1);
    Award awardFirewood = Award.getAwardByID(2);

    Award awardWater = Award.getAwardByID(3);

    @Override
    public boolean onLocation() {


        int obsNumber = this.randomObstacleNumber();
        System.out.println("You are currently here :  " + this.getName());
        System.out.println("Be careful  : " + obsNumber + " number " + this.getObstacle().getName() + " are living ");





        if (combat(obsNumber)) {





            if (this.obstacle.getId() == 1) {
                this.getPlayer().getInventory().getRewards().add("Food");
                System.out.println("All the zombies have died.");

            } else if (this.getObstacle().getId() == 2) {
                this.getPlayer().getInventory().getRewards().add("Firewood");
                System.out.println("All the vampires have died.");
            } else if (this.getObstacle().getId() == 3) {
                System.out.println("All the bears have died.");
                this.getPlayer().getInventory().getRewards().add("Water");

            } else if (this.getObstacle().getId() == 4) {
                this.getPlayer().getInventory().getRewards().add("Reward");
                System.out.println("All the snakes have died.");
                // I added the prize here because in the mining map, you can either win or not win a prize.
                // Entering here and defeating the monsters doesn't prevent you from completing the game!
            }


            return true;
        }
        if (this.getPlayer().getHealth() <= 0) {
            System.out.println("I'm sorry to hear that you have died.");

            return false;
        }


        return true;
    }

    public int getMaxObstacle() {
        return maxObstacle;
    }

    public void setMaxObstacle(int maxObstacle) {
        this.maxObstacle = maxObstacle;
    }

    public int randomObstacleNumber() {
        Random r = new Random();
        return r.nextInt(this.getMaxObstacle()) + 1;
    }

    public Obstacle getObstacle() {
        return obstacle;
    }

    public void setObstacle(Obstacle obstacle) {
        this.obstacle = obstacle;

    }

    public boolean combat(int obsNumber) {


        if (onlyOnePrize() == false) {
            return false;
        }

        if (firstToAttack() == true) {
            for (int i = 1; i <= obsNumber; i++) {
                this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
                playerStats();
                obstacleStats(i);


                while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {


                    System.out.println("You were the one who first attacked. ");
                    System.out.println("<A>ttack or <E<scape  ");
                    String selectCombat = input.nextLine().toLowerCase();
                    if (selectCombat.equals("a")) {


                        this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                        afterHit();
                        if (this.getObstacle().getHealth() > 0) {
                            System.out.println();
                            System.out.println("Afterwards, the monster attacked you.");
                            this.getPlayer().setHealth(this.getPlayer().getHealth() - this.getObstacle().getDamage());

                            afterHit();
                        }

                    } else {

                        return false;

                    }


                }
                if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {

                    System.out.println("You defeated the enemy !!");
                    System.out.println(this.getObstacle().getMoney() + " You won the Prize Money !");


                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
                    System.out.println("Current Balance : " + this.getPlayer().getMoney());


                } else {
                    return false;
                }



            }
            if (this.getObstacle().getId() == 4) {

                havingItemPossibility();
            }


        } else {
            //Monster begins to attack
            System.out.println("The monster was the one attacked you");
            for (int i = 1; i <= obsNumber; i++) {
                this.getObstacle().setHealth(this.getObstacle().getOriginalHealth());
                playerStats();
                obstacleStats(i);


                while (this.getPlayer().getHealth() > 0 && this.getObstacle().getHealth() > 0) {



                    this.getPlayer().setHealth(this.getPlayer().getHealth() - this.getObstacle().getDamage());
                    afterHit();
                    if (getPlayer().getHealth() > 0) {
                        System.out.println();
                        System.out.println("<A>ttack or <E<scape  ");
                        String selectCombat = input.nextLine().toLowerCase();
                        if (selectCombat.equals("a")) {
                            this.getObstacle().setHealth(this.getObstacle().getHealth() - this.getPlayer().getTotalDamage());
                            afterHit();
                        } else {

                            return false;

                        }
                    }


                }

                if (this.getObstacle().getHealth() < this.getPlayer().getHealth()) {


                    System.out.println("You defeated the enemy !!");
                    System.out.println(this.getObstacle().getMoney() + " You got the prize money !");


                    this.getPlayer().setMoney(this.getPlayer().getMoney() + this.getObstacle().getMoney());
                    System.out.println("Current Balance : " + this.getPlayer().getMoney());


                } else {
                    return false;
                }


            }
            if (this.getObstacle().getId() == 4) {
                //Second possibility
                havingItemPossibility();
            }


        }





        showInventory();

        return true;


    }

    public void playerStats() {
        System.out.println(" Player Values ");
        System.out.println("--------------------------");
        System.out.println("Health : " + this.getPlayer().getHealth());
        System.out.println("Weapon : " + this.getPlayer().getInventory().getWeapon().getName());
        System.out.println("Armor : " + this.getPlayer().getInventory().getArmor().getName());
        System.out.println("Damage " + this.getPlayer().getTotalDamage());
        System.out.println("Block : " + this.getPlayer().getInventory().getArmor().getBlock());
        System.out.println("Remaining Balance :" + this.getPlayer().getMoney());

    }

    public void obstacleStats(int i) {
        System.out.println(i + "." + "Monster Values ");
        System.out.println("*******************");
        System.out.println("Monster Name : " + this.getObstacle().getName());
        System.out.println("Health : " + this.getObstacle().getHealth());
        System.out.println("Damage :  " + this.getObstacle().getDamage());
        System.out.println("Prize Money : " + this.getObstacle().getMoney());
    }

    public void afterHit() {
        System.out.println("Player Health : " + this.getPlayer().getHealth());
        System.out.println(this.getObstacle().getName() + " Health :" + this.getObstacle().getHealth());
    }


    public void showInventory() {


        if (this.getObstacle().getId() == 1) {
            System.out.println("You won Food because you fought against and defeated all the Zombies in the Cave !!");
            this.getPlayer().getInventory().setAward(awardFood);


            System.out.println(this.getPlayer().getInventory().getAward().getName() + "\tIt is the prize that you won.");


        } else if (this.getObstacle().getId() == 2) {
            System.out.println("You won Firewood because you fought against and defeated all Vampires in the Forest !!");
            this.getPlayer().getInventory().setAward(awardFirewood);

            System.out.println(this.getPlayer().getInventory().getAward().getName() + "\tIt is the prize that you won.");


        } else if (this.getObstacle().getId() == 3) {
            System.out.println("You won Water because you fought against and defeated all Bears in the River!!!");


            this.getPlayer().getInventory().setAward(awardWater);

            System.out.println(this.getPlayer().getInventory().getAward().getName() + "\tIt is the prize that you won.");


        } else if (this.getObstacle().getId() == 4) {


            System.out.println(this.getPlayer().getInventory().getAward().getName() + "\tIt is the prize that you won.");
        }



    }


    public boolean onlyOnePrize() {


        if (this.getObstacle().getId() == 1 && this.getPlayer().getInventory().getAward().getId() == 1) {
            System.out.println("You have received the Food. Why you are trying to enter again!!!");

            System.out.println("<<<<<<<<<<Please select the location where  you haven't received the award  >>>>>>>>>>>>>>");


            return false;

        } else if (this.getObstacle().getId() == 2 && this.getPlayer().getInventory().getAward().getId() == 2) {
            System.out.println("You have received the Firewood. Why you are trying to enter again !!!");

            System.out.println("<<<<<<<<<<Please select the location where  you haven't received the award  >>>>>>>>>>>>>>");

            return false;

        } else if (this.getObstacle().getId() == 3 && this.getPlayer().getInventory().getAward().getId() == 3) {
            System.out.println("You have received the Water. Why you are trying to enter again !!!");
            System.out.println("<<<<<<<<<<Please select the location where  you haven't received the award  >>>>>>>>>>>>>>");
            return false;


        } else if (this.getObstacle().getId() == 4) {
            if (this.getPlayer().getInventory().getAward().getName().equals("Silah") || (this.getPlayer().getInventory().getAward().getName().equals("Tüfek")) ||
                    this.getPlayer().getInventory().getAward().getName().equals("Kılıç")) {
                System.out.println("You have received the Weapon. Why you are trying to enter again !!!");
                System.out.println("<<<<<<<<<<Please select the location where  you haven't received the award  >>>>>>>>>>>>>>");
                return false;

            } else if (this.getPlayer().getInventory().getAward().getName().equals("Hafif") || (this.getPlayer().getInventory().getAward().getName().equals("Orta")) ||
                    this.getPlayer().getInventory().getAward().getName().equals("Ağır")) {
                System.out.println("You have received the Armor. Why you are trying to enter again !!!");
                System.out.println("<<<<<<<<<<Please select the location where  you haven't received the award  >>>>>>>>>>>>>>");
                return false;
            } else if (this.getPlayer().getInventory().getAward().getName().equals("Para")) {
                System.out.println("You have received the Prize Money. Why you are trying to enter again !!!");
                System.out.println("<<<<<<<<<<Please select the location where  you haven't received the award  >>>>>>>>>>>>>>");
                return false;
            }


        }
        return true;
    }


    public boolean firstToAttack() {
        double randomNumber = Math.random() * 100;
        if (randomNumber <= 50) {
            return true;
        }
        return false;

    }


    public boolean havingItemPossibility() {

        double randomNumberForMine = Math.random() * 100;

// There is a possibility of winning a weapon.(General 15%).{Rifle, Sword, Gun}{15%,30%,50%} respectively.
// There is a possibility of gaining armor (General 15%){Heavy Armor, Medium Armor, Lightweight Armor}{20%, 30%, 50%}
// The area where there is a possibility of making money.(25% General) (10,5, 1 amount of money){20%,30%,50%}
// The 45% where you win nothing.(45% General)
        if (randomNumberForMine <= 15) {

            //We are where there is a possibility of winning a weapon.(General 15%)

            double randomNumberForWeapons = Math.random() * 100;

            if (randomNumberForWeapons <= 20) {
                // 20% chance of winning a rifle


                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(3));
                this.getPlayer().getInventory().getAward().setName(Weapon.getWeaponObjByID(3).getName());

            } else if (randomNumberForWeapons > 20 && randomNumberForWeapons <= 50) {

                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(2));
                // 30% chance of winning a Sword


                this.getPlayer().getInventory().getAward().setName(Weapon.getWeaponObjByID(2).getName());

            } else {

                // 50% chance of winning a gun
                this.getPlayer().getInventory().setWeapon(Weapon.getWeaponObjByID(1));

                this.getPlayer().getInventory().getAward().setName(Weapon.getWeaponObjByID(1).getName());

            }


            return true;
        } else if (randomNumberForMine > 15 && randomNumberForMine <= 30) {
           // We are where there is a possibility of gaining armor (15%)

            double randomNumberForArmor = Math.random() * 100;


            if (randomNumberForArmor <= 20) {
                //20% chance of winning  Heavy Armor

                this.getPlayer().getInventory().setArmor(Armor.getArmorByID(3));
                this.getPlayer().getInventory().getAward().setName(Armor.getArmorByID(3).getName());

            } else if (randomNumberForArmor > 20 && randomNumberForArmor <= 50) {
                //30% chance of winning  Medium Armor


                this.getPlayer().getInventory().setArmor(Armor.getArmorByID(2));
                this.getPlayer().getInventory().getAward().setName(Armor.getArmorByID(2).getName());

            } else {
                // 50% chance of winning Lightweight(Allecret)
                this.getPlayer().getInventory().setArmor(Armor.getArmorByID(1));
                this.getPlayer().getInventory().getAward().setName(Armor.getArmorByID(1).getName());
            }

            return true;

        } else if (randomNumberForMine > 30 && randomNumberForMine <= 55) {
            // We are in the area where there is a possibility of making money.(25% General)



            double randomNumberForMoney = Math.random() * 100;

            if (randomNumberForMoney <= 20) {

                int balance = 10;
                this.getPlayer().setMoney(this.getPlayer().getMoney() + balance);
                this.getPlayer().getInventory().getAward().setName(Award.getAwardByID(4).getName());
                // The amount of 10 is where the probability of winning money is 20 percent.


            } else if (randomNumberForMoney > 20 && randomNumberForMoney <= 50) {
               // The amount of 5 is where the probability of winning money is 30 percent.

                int balance = 5;
                this.getPlayer().setMoney(this.getPlayer().getMoney() + balance);
                this.getPlayer().getInventory().getAward().setName(Award.getAwardByID(4).getName());

            } else {
                int balance = 1;
                this.getPlayer().setMoney(this.getPlayer().getMoney() + balance);

                // The amount of 1 is where the probability of winning money is 50 percent.
                this.getPlayer().getInventory().getAward().setName(Award.getAwardByID(4).getName());
            }


            return true;
        } else {
            // The 45% where you win nothing.
            this.getPlayer().getInventory().getAward().setName(Award.getAwardByID(5).getName());
            return false;
        }


    }


}