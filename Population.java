import java.util.Scanner;
import java.text.DecimalFormat;

public class Population {
    public static void main(String[] args) {

        DecimalFormat df = new DecimalFormat("#0.000");
        Scanner keyb = new Scanner(System.in);

        int anneeInitiale = 2011;        // annee initiale
        double tauxCroissance = 1.2;     // taux de croissance, en %
        double populationInitiale = 7.0; // population initiale, en milliard d'humains

        double populationCourante = populationInitiale; // population mondiale pour l'annee courante
        int anneeCourante = anneeInitiale;              // annee de calcul

        System.out.println("====---- PARTIE 1 ----====");
        System.out.println("Population en " + anneeCourante + " : " + df.format(populationCourante));

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/

        // ===== PARTIE 1 =====
        int anneefinale;
        int nb;
        double populationFinale;
        
        do{
        System.out.print("Quelle année (> 2011) ? ");
        anneefinale = keyb.nextInt();
        }while(anneefinale<=anneeInitiale);
        nb=anneefinale-anneeInitiale;
        populationFinale=populationInitiale * Math.exp(nb*(tauxCroissance/100));
        System.out.println("Population en " + anneefinale + " : " +  df.format(populationFinale));


        // ===== PARTIE 2 =====
        System.out.println("\n====---- PARTIE 2 ----====");
        double populationCible;
        do{
        System.out.print("Combien de milliards (> 7.0) ? ");
        populationCible = keyb.nextDouble();
        }while(populationCible<7.0);
        do{
        anneeCourante++;
        nb=anneeCourante-anneeInitiale;
        populationCourante=populationInitiale * Math.exp(nb*(tauxCroissance/100));
        System.out.println("Population en " + anneeCourante + " : " + (df.format(populationCourante)));
        }while(populationCourante<=populationCible);


        // ===== PARTIE 3 =====
        System.out.println("\n====---- PARTIE 3 ----====");
        anneeInitiale=2011;
        anneeCourante=anneeInitiale;
        populationInitiale = 7.0;
        do{
        anneeCourante++;
        nb=anneeCourante-anneeInitiale;
        populationCourante=populationInitiale * Math.exp(nb*(tauxCroissance/100));
        if((populationCourante/2)>=populationInitiale){
        populationInitiale =  populationCourante;
        tauxCroissance/=2;
        anneeInitiale = anneeCourante;
        }
        System.out.print("Population en " + anneeCourante + " : " + (df.format(populationCourante)));
        System.out.println("; taux de croissance : " + tauxCroissance + "%");
        }while(populationCourante<=populationCible);

        
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
    }
}
