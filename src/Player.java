import java.util.List;
import java.util.Scanner;

public class Player {
    private int damage;
    private int health;
    private int money;
    private String charName;
    private String name;
    private final Scanner input = new Scanner(System.in);
    private Inventory inventory;
    private int id;
    private Award award;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Inventory getInventory() {

        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    Player(String name) {

        this.name = name;
        this.inventory = new Inventory();
    }

    public void selectChar() {

        GameChar[] charList = {new Samurai(), new Archer(), new Knight()};
        for (GameChar gameChar : charList

        ) {
            System.out.println("Id :" + gameChar.getId() +
                    "\t Character    : " + gameChar.getName() +
                    "\t Damage  : " + gameChar.getDamage() +
                    "\t Healthy : " + gameChar.getHealth() +
                    "\t Money   : " + gameChar.getMoney());

        }
        System.out.print("Please enter a character:  ");
        int selectChar = input.nextInt();

        switch (selectChar) {
            case 1:
                initPlayer(new Samurai());
                break;
            case 2:
                initPlayer(new Archer());
                break;
            case 3:
                initPlayer(new Knight());
                break;
            default:
                initPlayer(new Samurai());

        }
        System.out.println("Character : " + this.getCharName() + ", Damage : " + this.getDamage() + ", Healthy : " + this.getHealth() + ", Money : " + getMoney());


    }

    public void initPlayer(GameChar gameChar) {
        this.damage = gameChar.getDamage();
        this.health = gameChar.getHealth();
        this.money = gameChar.getMoney();
        this.charName = gameChar.getName();
    }

    public void printInfo() {
        System.out.println("Armor : " + this.getInventory().getWeapon().getName() +
                ", Armor  :" + this.getInventory().getArmor().getName() +
                ", Block : " + this.getInventory().getArmor().getBlock() +
                ", Damage : " + this.getDamage() +
                ", Healthy : " + this.getHealth() +
                ", Money : " + this.getMoney()+
                ", Awards : "
                //burayı adam gibi yap --- ödülleri göstersin


        );
    }public  int getTotalDamage(){
        return damage + this.getInventory().getWeapon().getDamage();
    }


    public int getDamage() {
        return damage + this.getInventory().getWeapon().getDamage() ;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health + this.getInventory().getArmor().getBlock();
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoney() {
        return money ;
    }

    public Award getAward() {
        return award ;
    }


    public void setAward(Award award) {
        this.award = award;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
