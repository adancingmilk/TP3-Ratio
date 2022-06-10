package tp3;

import java.util.Scanner;

public class Main {
    private static final int NB_COUREURS = 3;
    public static void main(String[] args) {
        Coureurs coureurs = new Coureurs();
        coureurs.generateCoureurs(NB_COUREURS); //Génère les coureurs

        Course course = new Course(NB_COUREURS);

        printOptions(); //Affichage des options
        switch (selectChoix()) {
            case 1: coureurs.toString(); break;
            case 2: coureurs.classement(); break;
            case 3: coureurs.estArrive();  break;
            case 4: coureurs.aAbandonne(); break;
            case 5: coureurs.estDisqualifie(); break;
            case 6: break;
            case 7: course.StartCourse(); break;
            case 8: course.EndCourse(); break;
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
        System.out.println("8 - Terminer la course");
    }

    public static int selectChoix() {
        Scanner sc = new Scanner(System.in);
        int rep = -1;
        do {
            System.out.print("Entrez un nombre : ");
            rep = sc.nextInt();
        } while(rep > 0 && rep < 9);

        return rep;
    }
}
