public class DisplayText {
   
      void displayStartMenu() {
      System.out.println();
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
      System.out.println("(1) Start Game");
      System.out.println("(2) Game Rules");
      System.out.println("(3) Benefits of the Concentrartion Game");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");  
      System.out.print("Select from above: ");   
   }
   
   
   void displayEndMeny() {
      System.out.println();  
      System.out.println("~~~~~~~~~~~~~~~~~~~"); 
      System.out.println("(1) Play again");
      System.out.println("(2) View points");
      System.out.println("(3) Exit Game");
      System.out.println("~~~~~~~~~~~~~~~~~~~");  
      System.out.print("Please select from above: ");  
   }
     void gameRules() {
      System.out.println();
      System.out.println("There are three different levels: Easy , Medium and Hard."); 
      System.out.println("You can play this game by yourself or with a friend."); 
      System.out.println("You have to enter two-digit number for one cooridinate, for example 11( the first digit is for row and the second one for column)");
      System.out.println("1 PLAYER ");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
      System.out.println("You have to uncover two letters.If the letters match, the letters remain uncovered and you score one point");
      System.out.println("If the letters fail to match, they are recovered and you try again"); 
      System.out.println("2 PLAYERS ");
      System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); 
      System.out.println("Players take turns trying to discover the letter pairs.A player uncovers two letters");
      System.out.println("If the letters match, the letters remain uncovered, the player scores one point, and he/she is allowed to uncover two more letters.");
      System.out.println("If the letters fail to match, they are recovered and the next player tries");
      System.out.println("The player with the most points wins.");
      
   
   }
      
   void gameBenefits() { 
      System.out.println();
      System.out.println("It's a great game to train and boost your memory in a playful way. ");
      System.out.println("Regular players, will train their brain and thus improve their memory.");
   }
   
      public void displayBoard(int cards[][] , boolean coveredCards[][]) {
      System.out.print("     ");
      for(int i = 0; i < cards[0].length ; i++){
         System.out.print(i+ 1 + " ");}
      System.out.println();
      System.out.print("    ");
      for( int i = 0; i < cards[0].length ; i++){
         System.out.print("--");}
      System.out.println();
   
      for (int r = 0; r < cards.length; r++) {
         System.out.print(" " + (r + 1) + " | ");
         for (int c = 0; c < cards[0].length; c++) {
            if (coveredCards[r][c]) {
               System.out.print(cards[r][c] + " "); }
            else { System.out.print("o "); }
         }
         System.out.println();
      }
      System.out.println();
   }
   
   
}