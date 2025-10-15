import java.util.ArrayList;

public class Frazione implements Operando{
    private int numeratore;
    private int denominatore;

    public Frazione(){
        numeratore = 1;
        denominatore = 1;
    }

    public Frazione(int numeratore, int denominatore){
        if(denominatore == 0){
            this.numeratore = 1;
            this.denominatore = 1;
            throw new ArithmeticException("Denominatore non valido");
        }

        this.numeratore = numeratore;
        this.denominatore = denominatore;
    }

    public String stampa(){
        return numeratore + "/" + denominatore;
    }

    public String toString(String message){
        return message + ": " + numeratore + "/" + denominatore;
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
        ArrayList<Integer> fattNum = fattorizzazione(numeratore);
        ArrayList<Integer> fattDenom = fattorizzazione(denominatore);
        ArrayList<Integer> fattNumSemplificato = fattNum;
        ArrayList<Integer> fattDenoumSemplificato = fattDenom;

        for (int numero : fattNum) {
            if (fattDenom.contains(numero)) {
                fattNumSemplificato.remove(numero);
                fattDenoumSemplificato.remove(numero);
            }
        }

        int numSemplificato = 1;
        for(int numero : fattNumSemplificato)
            numSemplificato *= numero;

        int denomSemplificato = 1;
        for(int numero : fattDenoumSemplificato)
            denomSemplificato *= numero;

        return new Frazione(numSemplificato, denomSemplificato);
    }
}
