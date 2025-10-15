import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Frazione f1 = creaFrazioneInput();
        System.out.println(f1.toString("Prima frazione: "));
        Frazione f2 = creaFrazioneInput();
        System.out.println(f2.toString("Seconda frazione: "));

        System.out.println("\n-------------------------\n");
        System.out.println("Valore reale della prima frazione: " + f1.calcolo());
        System.out.println("Valore reale della seconda frazione: " + f2.calcolo());

        Frazione f3 = f1.moltiplicazione(f2);
        System.out.println(f3.toString("\nTerza frazione (f1*f2): "));

        Frazione f4 =  f3.semplificazione();
        System.out.println(f4.toString("\nQuarta frazione (f3 semplificata): "));

        Frazione f5 =  f1.somma(f2);
        System.out.println(f5.toString("\nQuinta frazione (f1+f2): "));

        Frazione f6 =  f1.differenza(f2);
        System.out.println(f6.toString("\nSesta frazione (f1-f2): "));

        Frazione f7 =  f1.inversione();
        System.out.println(f7.toString("\nSettima frazione (inversione di f1): "));

        Frazione f8 =  f1.divisione(f2);
        System.out.println(f8.toString("\nOttava frazione (f1/f2): "));

        System.out.println("\n-------------------------\n");
        try{
            System.out.println("Collaudo dell'eccezione: inserire denominatore nullo");
            creaFrazioneInput();
        } catch (DenominatoreNulloException e){
            System.err.println("ERRORE: " + e);
        }
    }

    public static Frazione creaFrazioneInput(){
        Scanner sc =  new Scanner(System.in);

        System.out.print("Inserisci il numeratore della frazione: ");
        int numeratore = sc.nextInt();

        System.out.print("Inserisci il denominatore della frazione: ");
        int denominatore = sc.nextInt();

        return new Frazione(numeratore, denominatore);
    }
}