import pakiet1.Edycja;
import java.lang.Exception;
import java.util.Scanner;


public class Inne implements Edycja
{
    double cena;
    int ilosc;
    String opis;
    double wymiarX;
    double wymiarY;

    public Inne()
    {
        this.cena = 0.0;
        this.ilosc = 0;
        this.opis = "??";
        this.wymiarX = 0;
        this.wymiarY = 0;
    }

    public Inne(double cena, int ilosc, String opis, double wymiarX, double wymiarY)
    {
        this.opis = opis;

        if(cena <=0)
        {
            this.cena = 10.99;
        }
        else
        {
            this.cena = cena;
        }

        if(ilosc <= 0 )
        {
            this.ilosc = 1;
        }
        else
        {
            this.ilosc = ilosc;
        }

        if(wymiarX <=0)
        {
            this.wymiarX = 1;
        }
        else
        {
            this.wymiarX = wymiarX;
        }

        if(wymiarY <=0)
        {
            this.wymiarY = 1;
        }
        else
        {
            this.wymiarY = wymiarY;
        }
    }


    public void edytuj()
    {
        String s;
        int i;
        double d;

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. WymiarX");
        System.out.println("2. WymiarY");
        System.out.println("3. Cena");
        System.out.println("4. Ilosc");
        System.out.println("5. Opis");

        switch(scanner.nextInt())
        {
            case 1:
                System.out.println("Nowy wymiar X:");
                d=scanner.nextDouble();
                this.wymiarX = d;
                break;
            case 2:
                System.out.println("Nowy wymiar Y:");
                d=scanner.nextDouble();
                this.wymiarY =  d;
                break;
            case 3:
                System.out.println("Nowa cema:");
                d=scanner.nextDouble();
                this.cena = d;
                break;
            case 4:
                System.out.println("Nowa ilsoc do druku:");
                i=scanner.nextInt();
                this.ilosc = i;
                break;
            case 5:
                System.out.println("Nowy opis:");
                scanner.nextLine();
                s = scanner.nextLine();
                this.opis = s;
                break;
            default:
                break;
        }
    }


    public void nowaIlosc(int nIlosc) throws Wyjatek
    {
        if(nIlosc < 0)
        {
            throw new Wyjatek();
        }
        else
        {
            this.ilosc = nIlosc;
        }
    }
}
