import java.util.Scanner;

public class Program {
    public static void menu() {
        System.out.println("Wybierz rodzaj kuchni: włoska - 1, francuska - 2, meksykańska - 3, polska - 4: ");
        try {
            Scanner scanner = new Scanner(System.in);
            short wybor = scanner.nextShort();
            switch (wybor) {
                case 1:
                    System.out.println("Wybrano kuchnię włoską.\n" +
                            "Wybierz posiłek z menu: pizza - 1, makaron - 2");
                    Scanner scanner2 = new Scanner(System.in);
                    short wybor2 = scanner.nextShort();
                    switch (wybor2) {
                        case 1:
                            quantity();
                            System.out.println("Wybrano: pizza");
                            navigate();
                            break;
                        case 2:
                            quantity();
                            System.out.println("Wybrano: makaron");
                            navigate();
                            break;
                        default:
                            System.out.println("To danie jest nie dostępne!");
                            navigate();
                            break;
                    }
                    navigate();
                    break;
                case 2:
                    System.out.println("Wybrano kuchnię francuską.\n" +
                            "Wybierz posiłek z menu: ratatouille - 1, quiche -2");
                    Scanner scanner3 = new Scanner(System.in);
                    short wybor3 = scanner.nextShort();
                    switch (wybor3) {
                        case 1:
                            System.out.println("Wybrano: ratatouille");
                            quantity();
                            navigate();
                            break;
                        case 2:
                            quantity();
                            System.out.println("Wybrano: quiche");
                            navigate();
                            break;
                        default:
                            System.out.println("To danie jest nie dostępne!");
                            navigate();
                            break;
                    }
                    navigate();
                    break;
                case 3:
                    System.out.println("Wybrano kuchnię meksykańską.\n" +
                            "Wybierz posiłek z menu: burrito - 1, quesadilla - 2");
                    Scanner scanner4 = new Scanner(System.in);
                    short wybor4 = scanner.nextShort();
                    switch (wybor4) {
                        case 1:
                            System.out.println("Wybrano: burrito");
                            quantity();
                            navigate();
                            break;
                        case 2:
                            System.out.println("Wybrano: quesadilla");
                            quantity();
                            navigate();
                            break;
                        default:
                            System.out.println("To danie jest nie dostępne!");
                            quantity();
                            navigate();
                            break;
                    }
                    navigate();
                    break;
                case 4:
                    System.out.println("Wybrano kuchnię polską.\n" +
                            "Wybierz posiłek z menu: pierogi - 1, gulasz - 2");
                    Scanner scanner5 = new Scanner(System.in);
                    short wybor5 = scanner.nextShort();
                    switch (wybor5) {
                        case 1:
                            quantity();
                            System.out.println("Wybrano: pierogi");
                            navigate();
                            break;
                        case 2:
                            quantity();
                            System.out.println("Wybrano: gulasz");
                            navigate();
                            break;
                        default:
                            System.out.println("To danie jest nie dostępne!");
                            navigate();
                            break;
                    }
                default:
                    System.out.println("Nie oferujemy dań z tej kuchni!");
                    navigate();
                    break;
            }
        } catch (Exception ex) {
            System.out.println("Wystąpił błąd - " + ex.toString() + " - Powrót do menu");
            menu();
        }
    }

    public static void navigate(){
        boolean exit = false;
        char[] pozegnanie = new char[]{'D', 'z', 'i', 'e', 'k', 'u', 'j', 'e', 'm', 'y', ' ', 'z', 'a', ' ', 's', 'k', 'o', 'r', 'z', 'y', 's', 't', 'a', 'n', 'i', 'e', ' ', 'z', ' ', 'n', 'a', 's', 'z', 'e', 'j', ' ', 'o', 'f', 'e', 'r', 't', 'y', '.'};

        while(exit != true){
            System.out.println("Nowy posiłek - 1, Zakończ - 0");
            Scanner scanner = new Scanner(System.in);
            int navi = scanner.nextInt();
            switch (navi) {
                case 1:
                    menu();
                case 0:
                    exit = true;
                    System.out.println(pozegnanie);
                    System.exit(0);
            }
        }
    }
    public static void quantity(){
        System.out.println("Podaj ilość: ");
        Scanner scanner = new Scanner(System.in);
        long quantity = scanner.nextLong();
        System.out.println("Ilość: "+quantity);
    }

    public static void main(String[] args) {
        System.out.println("Witamy w firmie dostarczającej gorące posiłki na telefon!");
        menu();
    }
}