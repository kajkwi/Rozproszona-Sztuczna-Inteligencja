//import pakiet2.Pismo;
//wykorzystanie bez importowania


public class Ksiazka extends pakiet2.Pismo
{
    String autor;
    String wydawnictwo;

    public Ksiazka()
    {
        this.tytul = "??";
        this.autor = "??";
        this.cena = 0.0;
        this.ilosc = 0;
        this.wydawnictwo = "??";
    }

    public Ksiazka (String tytul, String autor, double cena, int ilosc, String wydawnictwo)
    {
        this.tytul = tytul;
        this.autor = autor;
        this.wydawnictwo = wydawnictwo;

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
        if ((this.ilosc - ile) <= 0)
        {
            System.out.println("Drukowanie niemozliwe! Jest zamowione " +
                    this.ilosc + " ksiazek a chcesz wydrukowac " + ile);
        }
        else
        {
            this.ilosc -= ile;
            System.out.println("Wydrukowano " + ile + " ksiazek, do zrealizowania" +
                    "zamowienia pozostalo " + this.ilosc + " ksiazek.");
        }


    }

}
