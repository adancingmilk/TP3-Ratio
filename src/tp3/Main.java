package tp3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Coureurs coureurs = new Coureurs();
        coureurs.generateCoureurs(); //Génère les coureurs

        Course course = new Course(coureurs);

        printOptions(); //Affichage des options
        Scanner sc = new Scanner(System.in);
        int rep = -1;
        do {                                                // on rentre dans le programme
            System.out.print("Entrez un nombre : ");
            rep = sc.nextInt();
            switch (rep) {
                case 1: System.out.println(coureurs.toString()); break;
                case 2: Course.classement(); break;
                case 3: coureurs.estArrive(); break;
                case 4: coureurs.aAbandonne(); break;
                case 5: coureurs.estDisqualifie(); break;
                case 6:
                    String nom;
                    int numDoss;
                    System.out.println("Entrez un nom :");
                    Scanner sc2 = new Scanner(System.in);
                    nom = sc2.nextLine();
                    System.out.println("Entrez un numéro de dossard :");
                    numDoss = sc2.nextInt();
                    coureurs.add(new Coureur(nom, numDoss));
                    break;
                case 7: course.StartCourse(); break;
                case 8: System.out.println(course.currentTime()); break;
                case 9: course.EndCourse(); break;
                case 10: course.getTime(); break;
                case 11: course.compareTwo(); break;
                default: break;
                }
            }while(rep > 0 && rep < 12);
    }

    public static void printOptions() { // les différentes actions à faire
        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("1 - Afficher les coureurs");
        System.out.println("2 - Afficher le classement provisoire");
        System.out.println("3 - Enregistrer une arrivée");
        System.out.println("4 - Enregistrer un abandon");
        System.out.println("5 - Enregistrer une disqualification");
        System.out.println("6 - Ajouter un ou des coureur-s");
        System.out.println("7 - Démarrer la course");
        System.out.println("8 - Le temps actuel d'un coureur");
        System.out.println("9 - Terminer la course");
        System.out.println("10 - Obtenir le temps d'un coureur");
        System.out.println("11 - Comparer le temps de deux coureurs");
        System.out.println("Autre - Quitter le programme");
    }

    //public static int selectChoix() {


   // }
}
