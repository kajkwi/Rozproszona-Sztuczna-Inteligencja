
import pakiet1.Edycja;
import pakiet2.Pismo;

import java.util.Scanner;

public class Kalendarz extends Pismo implements Edycja
{
    String autor;
    int rok;

    public Kalendarz()
    {
        this.tytul = "??";
        this.autor = "??";
        this.cena = 0.0;
        this.ilosc = 0;
        this.rok = 2019;
    }

    public Kalendarz (String tytul, String autor, double cena, int ilosc, int rok)
    {
        this.tytul = tytul;
        this.autor = autor;

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

        if (rok < 2019)
        {
            this.rok = 2019;
        }
        else
        {
            this.rok = rok;
        }
    }

    public void drukuj(int ile)
    {
        if((this.ilosc - ile) <=0)
        {
            System.out.println("Drukowanie niemozliwe! Jest zamowione "+
                    this.ilosc+" kalendarzy a chcesz wydrukowac "+ile);
        }
        else
        {
            this.ilosc -= ile;
            System.out.println("Wydrukowano "+ile+" kalendarzy, do zrealizowania" +
                    "zamowienia pozostalo "+this.ilosc+" sztuk.");
        }
    }

    public void edytuj()
    {
        String s;
        int i;
        double d;

        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Tytul");
        System.out.println("2. Autor");
        System.out.println("3. Cena");
        System.out.println("4. Ilosc");
        System.out.println("5. Rok");

        switch(scanner.nextInt())
        {
            case 1:
                System.out.println("Nowy tytul:");
                scanner.nextLine();
                s = scanner.nextLine();
                this.tytul = s;
                break;
            case 2:
                System.out.println("Nowy autor:");
                scanner.nextLine();
                s = scanner.nextLine();
                this.autor = s;
                break;
            case 3:
                System.out.println("Nowa cema:");
                d = scanner.nextDouble();
                this.cena = d;
                break;
            case 4:
                System.out.println("Nowa ilosc do druku:");
                i = scanner.nextInt();
                this.ilosc = i;
                break;
            case 5:
                System.out.println("Nowy rok:");
                i = scanner.nextInt();
                this.rok = i;
                break;
            default:
                break;
        }
    }

}
