package tp3;

import java.util.Scanner;

public class Main {
    private static final int NB_COUREURS = 3;
    public static void main(String[] args) {
        Coureurs coureurs = new Coureurs();
        coureurs.generateCoureurs(NB_COUREURS); //Génère les coureurs

        Course course = new Course(coureurs);

        printOptions(); //Affichage des options
        int choix = selectChoix();
        switch (choix) {
            case 1: coureurs.toString(); break;
            case 2: coureurs.classement(); break;
            case 3: coureurs.estArrive();  break;
            case 4: coureurs.aAbandonne(); break;
            case 5: coureurs.estDisqualifie(); break;
            case 6:
                String nom;
                int numDoss;
                Scanner sc = new Scanner(System.in);
                nom = sc.nextLine();
                numDoss = sc.nextInt();
                coureurs.add(new Coureur(nom, numDoss));
                break;
            case 7: course.StartCourse(); break;
            case 8: System.out.println(course.currentTime()); break;
            case 9: course.EndCourse(); break;
            default: break;
        }
    }

    public static void printOptions() {
        System.out.println("Que souhaitez-vous faire ?");
        System.out.println("1 - Afficher les coureurs");
        System.out.println("2 - Afficher le classement provisoire");
        System.out.println("3 - Enregistrer une arrivée");
        System.out.println("4 - Enregistrer un abandon");
        System.out.println("5 - Enregistrer une disqualification");
        System.out.println("6 - Ajouter un ou des coureur-s");
        System.out.println("7 - Démarrer la course");
        System.out.println("8 - Le temps actuel d'un courreur");
        System.out.println("9 - Terminer la course");
    }

    public static int selectChoix() {
        Scanner sc = new Scanner(System.in);
        int rep = -1;
        do {
            System.out.print("Entrez un nombre : ");
            rep = sc.nextInt();
        } while(rep > 0 && rep < 10);

        return rep;
    }
}
