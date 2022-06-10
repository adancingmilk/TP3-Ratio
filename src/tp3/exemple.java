package tp3;

import java.util.*;

public class exemple {
    public static void main(String[] args) {



//        System.out.print("Écrivez une phrase : ");
//        String phrase = sc.nextLine();
//
//        String test = "bonjour je suis ratio";
//        char[] testArray = test.toCharArray();
//        System.out.println(phrase.toUpperCase());
//
//        char[] phraseArray = phrase.toCharArray();
//
//        String phraseUpdated = "";
//        for(char c : phraseArray) {
//            if(c == 'a')
//                phraseUpdated += '*';
//            else
//                phraseUpdated += c;
//        }
//        /*int lala = 7;
//        for (int i=0; i<test.length(); i++){
//            if (i >=5 && i<=12 && phraseArray.length>=7) {
//                if (testArray[i] != phraseArray[i-5])
//                    lala -= 1;
//            }
//        }
//        if (lala == 7)
//            System.out.println("ok");
//        else
//            System.out.println("ratio");*/
//
//        System.out.println(phraseUpdated);

        String mot = "";
        List<String> mots = new ArrayList<>();
        do{
            System.out.print("Écrivez un mot ('fin' pour stopper): ");
            Scanner sc2 = new Scanner(System.in);

            mot = sc2.nextLine();
            mots.add(mot);

        }while(!Objects.equals(mot, "fin"));

        mots.sort(String.CASE_INSENSITIVE_ORDER);
        System.out.println(mots.get(0));
        System.out.println(mots.get(mots.size()-1));
    }
}
