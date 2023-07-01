public class ToolStore extends NormalLoc {

    public ToolStore(Player player) {
        super(2, player, "ToolStore");


    }

    @Override

    public boolean onLocation() {
        System.out.println("---------Welcome to the ToolStore !----------");

        boolean isShow = true;
        while (isShow) {
            System.out.println("1 - Weapons ");
            System.out.println("2 - Armors");

            System.out.println("3 - Exit ");


            System.out.println("Your choice is  : ");
            int selectCase = input.nextInt();
            while (selectCase < 1 || selectCase > 3) {
                System.out.println("Please enter a valid value !!!");
                selectCase = input.nextInt();

            }
            switch (selectCase) {
                case 1:
                    printWeapon();
                    buyWeapon();
                    break;
                case 2:
                    printArmor();
                    buyArmor();
                    break;
                case 3:
                    System.out.println("We'll be waiting for you again. ");
                    isShow = false;
                    break;
            }
        }

        return true;
    }

    public void printWeapon() {
        System.out.println("Weapons");
        System.out.println();
        for (Weapon w : Weapon.weapons()) {
            System.out.println("İtem name\t : " + w.getId() + "-" + w.getName() + "\tDamage : " + w.getDamage() + " \tPrice : " + w.getMoney());
        }
        System.out.println("0- Exit");

    }

    public void buyWeapon() {
        System.out.print("Please choose a weapon. :");

        int selectWeaponID = input.nextInt();

        while (selectWeaponID < 0 || selectWeaponID > Weapon.weapons().length) {
            System.out.println("Please enter a valid value !!");
            selectWeaponID = input.nextInt();
        }
        if (selectWeaponID != 0) {
            Weapon selectedWeapon = Weapon.getWeaponObjByID(selectWeaponID);
            if (selectedWeapon != null) {
                if (selectedWeapon.getMoney() > this.getPlayer().getMoney()) {
                    System.out.println("Your balance is not sufficient  !!");

                } else {
                    int balance = this.getPlayer().getMoney() - selectedWeapon.getMoney();

                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining balance : " + this.getPlayer().getMoney());


                    int balanceForWeapon = this.getPlayer().getDamage() + selectedWeapon.getDamage();
                    this.getPlayer().setDamage(balanceForWeapon);


                }


            }
        }

    }

    public void printArmor() {
        System.out.println("Armors");

        System.out.println();
        for (Armor a : Armor.armors()) {
            System.out.println("İtem name\t : " + a.getId() + "-" + a.getName() + "\tBlocking : " + a.getBlock() + " \tPrice : " + a.getPrice());
        }

        System.out.println("0 -Exit ");

    }

    public void buyArmor() {

        System.out.print("Please select one of the armors from the options.  ");

        int selectArmorID = input.nextInt();
        while (selectArmorID < 0 || selectArmorID > Armor.armors().length) {
            System.out.println("Please enter a valid value !! ");
            selectArmorID = input.nextInt();
        }
        if (selectArmorID != 0) {
            Armor selectedArmor = Armor.getArmorByID(selectArmorID);
            if (selectedArmor != null) {
                if (selectedArmor.getPrice() > this.getPlayer().getMoney()) {

                    System.out.println("Your balance is not sufficient !!!");
                } else {
                    int balance = this.getPlayer().getMoney() - selectedArmor.getPrice();
                    this.getPlayer().setMoney(balance);
                    System.out.println("Remaining balance : " + this.getPlayer().getMoney());

                    int balanceForArmor = this.getPlayer().getHealth() + selectedArmor.getBlock();
                    this.getPlayer().setHealth(balanceForArmor);


                }
            }
        }


    }


}
