
public class Obstacle {
    private int health;
    private int damage;
    private int money;
    private String name;
    private int id;

    private int originalHealth;


    public int getOriginalHealth() {
        return originalHealth;
    }

    public void setOriginalHealth(int originalHealth) {
        this.originalHealth = originalHealth;
    }

    public Obstacle(String name, int health, int damage, int id, int money){


        this.originalHealth = health;
        this.id = id;
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.money = money;
    }




    public void setMoney(int money) {
        this.money = money;
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



    public int getHealth(){
        return health ;
    }
    public void setHealth(int health){
        if(health <0){
            health =0;
        }
        this.health = health;
    }
    public int getDamage(){
        return  damage;
    }
    public void setDamage(int damage){
        this.damage = damage;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(){
        this.money = money;
    }
}


