import pakiet2.Pismo;

public class Gazeta extends Pismo
{
    int numer;
    String wydawca;

    public Gazeta()
    {
        this.tytul = "??";
        this.numer = 0;
        this.cena = 0.0;
        this.ilosc = 0;
        this.wydawca = "??";
    }

    public Gazeta (String tytul, int numer, double cena, int ilosc, String wydawca)
    {
        this.tytul = tytul;
        this.wydawca = wydawca;

        if(this.numer <= 0)
        {
            this.numer = 1;
        }
        else
        {
            this.numer = numer;
        }

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
    }

    public void drukuj(int ile)
    {
        if((this.ilosc - ile) <=0)
        {
            System.out.println("Drukowanie niemozliwe! Jest zamowione "+
                    this.ilosc+" gazet a chcesz wydrukowac "+ile);
        }
        else
        {
            this.ilosc -= ile;
            System.out.println("Wydrukowano "+ile+" gazet, do zrealizowania" +
                    "zamowienia pozostalo "+this.ilosc+" egzemplarzy.");
        }
    }
}
