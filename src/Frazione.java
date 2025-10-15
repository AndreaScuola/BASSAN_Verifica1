import java.util.ArrayList;

public class Frazione implements Operando{
    private int numeratore;
    private int denominatore;

    public Frazione(){
        numeratore = 1;
        denominatore = 1;
    }

    public Frazione(int numeratore, int denominatore){
        if(denominatore == 0)
            throw new DenominatoreNulloException("Denominatore non valido");

        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }

    public void stampa(){
        System.out.println(numeratore + "/" + denominatore);
    }

    public String toString(String message){
        char segnoFr;
        if(numeratore * denominatore > 0) segnoFr = '+';
        else segnoFr = '-';

        return message + ": " + segnoFr + Math.abs(numeratore) + "/" + Math.abs(denominatore);
    }

    public double calcolo(){
        return (double) numeratore / denominatore;
    }

    public ArrayList<Integer> fattorizzazione(int numero){
        ArrayList<Integer> fattori = new ArrayList<>();
        int i = 2;

        do{
            if(numero % i == 0){
                fattori.add(i);
                numero = numero / i;
            }
            else
                i++;
        } while(i <= numero/2);

        if(numero != 1)
            fattori.add(numero);

        return fattori;
    }

    public Frazione somma(Frazione f2){
        int numF3 = numeratore*f2.denominatore + f2.numeratore*denominatore;
        int denomF3 = denominatore*f2.denominatore;
        return new Frazione(numF3, denomF3);
    }

    public Frazione moltiplicazione(Frazione f2){
        return new Frazione(numeratore*f2.numeratore, denominatore*f2.denominatore);
    }

    public Frazione differenza(Frazione f2){
        int numF3 = numeratore*f2.denominatore - f2.numeratore*denominatore;
        int denomF3 = denominatore*f2.denominatore;
        return new Frazione(numF3, denomF3);
    }

    public Frazione inversione(){
        return new Frazione(denominatore, numeratore);
    }

    public Frazione divisione(Frazione f2){
        return new Frazione(numeratore*f2.denominatore, denominatore*f2.numeratore);
    }

    public Frazione semplificazione(){
        char segnoFr;
        if(numeratore * denominatore > 0) segnoFr = '+';
        else segnoFr = '-';

        ArrayList<Integer> fattNum = fattorizzazione(Math.abs(numeratore));
        ArrayList<Integer> fattDenom = fattorizzazione(Math.abs(denominatore));
        ArrayList<Integer> fattComuni = new ArrayList<Integer>();

        for (int numero : fattNum)
            if (fattDenom.contains(numero))
                fattComuni.add(numero);

        for (int numero : fattComuni){
            fattNum.remove(fattNum.indexOf(numero));
            fattDenom.remove(fattDenom.indexOf(numero));
        }

        int numSemplificato = 1;
        for(int numero : fattNum)
            numSemplificato *= numero;

        int denomSemplificato = 1;
        for(int numero : fattDenom)
            denomSemplificato *= numero;

        if(segnoFr == '-')
            numSemplificato *= -1;

        return new Frazione(numSemplificato, denomSemplificato);
    }
}
