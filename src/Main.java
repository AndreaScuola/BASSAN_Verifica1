import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Frazione f1 = creaFrazioneInput();
        System.out.println(f1.toString("Prima frazione: "));
        Frazione f2 = creaFrazioneInput();
        System.out.println(f2.toString("Seconda frazione: "));

        System.out.println("Valore reale della prima frazione: " + f1.calcolo());
        System.out.println("Valore reale della seconda frazione: " + f2.calcolo());

        Frazione f3 = f1.moltiplicazione(f2);
        System.out.println(f3.toString("Terza frazione (f1*f2): "));

        Frazione f4 =  f3.semplificazione();
        System.out.println(f4.toString("Quarta frazione (f3 semplificata): "));

        Frazione f5 =  f1.somma(f2);
        System.out.println(f5.toString("Quinta frazione (f1+f2): "));

        Frazione f6 =  f1.differenza(f2);
        System.out.println(f6.toString("Sesta frazione (f1-f2): "));

        Frazione f7 =  f1.inversione();
        System.out.println(f7.toString("Settima frazione (inversione di f1): "));

        Frazione f8 =  f1.divisione(f2);
        System.out.println(f8.toString("Ottava frazione (f1/f2): "));

        try{
            System.out.println("Collaudo delle eccezzioni: inserire denominatore nullo");
            creaFrazioneInput();
        } catch (DenominatoreNulloException e){
            System.out.println("Errore: " + e);
        }
    }

    public static Frazione creaFrazioneInput(){
        Scanner sc =  new Scanner(System.in);

        System.out.println("Inserisci il numeratore della frazione: ");
        int numeratore = sc.nextInt();

        System.out.println("Inserisci il denominatore della frazione: ");
        int denominatore = sc.nextInt();

        return new Frazione(numeratore, denominatore);
    }
}