import java.util.Scanner;

public class Game {

    public static Scanner input = new Scanner(System.in);


    public void start() {



        System.out.println("Welcome to the Adventure Game! ");

        System.out.print("Please enter your name : ");

        String playerName = input.next();

        Player player = new Player(playerName);


        System.out.println(player.getName() + " Welcome");

        System.out.println("Please select a character : ");
        Location location = null;
        BattleLoc battleLoc = null;
        player.selectChar();


        while (true) {
            player.printInfo();


            System.out.println("Please select the location you want to go to :");

            System.out.println("1- Safe House");
            System.out.println("2- Item Shop ");
            System.out.println("3- Go to the cave, the prize is <Food>, be careful.");

            System.out.println("4- Go to the forest, the prize is <Wood>, be careful!!");
            System.out.println("5- Go to the river, the prize is <Water>, be careful!!    ");
            System.out.println("6- Go to the mine, the prize is <Depends on your luck>, be careful!!  ");
            System.out.println("0 - Exit -->>  Terminate the game.");


            int selectLocation = input.nextInt();


            switch (selectLocation) {
                case 0:
                    location = null;
                    break;
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new ToolStore(player);
                    break;

                case 3:
                    location = new Cave(player);

                    break;
                case 4:
                    location = new Forest(player);
                    break;

                case 5:
                    location = new River(player);
                    break;

                case 6:
                    location = new Mine(player);
                    break;

                default:
                    System.out.println("Please enter a valid transaction. ");
                    break;
            }
            if (location == null) {
                System.out.println("You gave up too early !");
                break;
            }
            if (!location.onLocation()) {

                System.out.println(" Game Over");
                break;
            }

        }

    }
}
