import java.util.*;
public class Play{
   public static void main(String[] args) {
      System.out.print("WELCOME TO THE CONCENTRATION GAME"); 
      ConcentrationGame game = new ConcentrationGame();
      DisplayText display = new DisplayText(); 
      while (true) {
         display.displayStartMenu();
         Scanner sc = new Scanner(System.in);
         if(sc.hasNextInt()){
            int selectedOption = sc.nextInt();
         
            while (selectedOption != 1 && selectedOption != 2 && selectedOption != 3) {
            
               System.out.println("Please enter 1 or 2 or 3: ");
               if(sc.hasNextInt()) {
                  selectedOption = sc.nextInt();}
               else {
                  break; }
            }
            game.gameOption1(selectedOption); 
            if (selectedOption == 1) 
               break;
         } 
      
      }
   }
}