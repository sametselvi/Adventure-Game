public class Weapon {
    private String name;
    private int damage;
    private int money;
    private int id;

    public Weapon(String name, int id , int damage, int money){
        this.name = name;
        this.damage = damage;
        this.money = money;
        this.id = id;

    }
    public  static Weapon [] weapons(){
        Weapon[] weaponList= new Weapon[3];
        weaponList[0]= new Weapon("Gun", 1,2,5);
        weaponList[1]= new Weapon("Sword",2,3,35);
        weaponList[2]= new Weapon("Riffle", 3,7,45);


        return weaponList;
    }

    public static  Weapon getWeaponObjByID(int id){
        for(Weapon w: Weapon.weapons()){
            if(w.getId()==id){
                return w;
            }
        }
        return null;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }





}

