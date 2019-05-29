import java.util.*;
import java.util.concurrent.TimeUnit;
public class ConcentrationGame {
   ShuffleCards test = new ShuffleCards();
   DisplayText test1 = new DisplayText();
   private Player p1;
   private Player p2;
   Scanner s = new Scanner(System.in); 
   Scanner sc = new Scanner(System.in); 
   private String player;
   int gamePlayers; //nr i lojtareve
   
   void gameOption1(int selectedOption) {
      switch (selectedOption) {
         case 1:
            playersName();
            startGame();
            break;
         case 2:
            test1.gameRules();
            break;
         case 3:
            test1.gameBenefits();
            break;
         default:
            break;  }
   }
   
   void gameOption2(int selectedOption) {
      switch (selectedOption) {
         case 1:
            startGame();
            break;
         case 2:
            pointViewer();
            break;
         case 3:
            break;
         default:
            break; }
   }
   
   String winner() {
      if(p1.getPoints() > p2.getPoints())  
         return p1.getName(); 
      else if(p1.getPoints() == p2.getPoints())   
         return "Tie";  // Barazim
      else
         return p2.getName(); 
   }

   void pointViewer() {
      System.out.println(p1.toString());
      if(gamePlayers > 1) 
         System.out.println(p2.toString()); 
   }
   
   void playersName() {
      String name;
      System.out.print("(1) 1 Player\n(2) 2 players\nSelect from above: ");
      OUTER_LOOP:
      while (true) {
         s = new Scanner(System.in);
         INNER_LOOP: 
         if (s.hasNextInt()) {
            gamePlayers = s.nextInt();
            while(gamePlayers != 1 && gamePlayers != 2 ) {
               System.out.print("Please enter 1 for one player or 2 for two players: ");
               if(s.hasNextInt()) {
                  gamePlayers = s.nextInt(); 
                  break OUTER_LOOP; }
               else {
                  break INNER_LOOP; }
            }
            break;
         }
      }

      System.out.print("Enter your name: ");
      name = sc.nextLine();
      while (name.isEmpty() || name.equals(" ")) {
         System.out.print("Please enter your name: ");
         name = sc.nextLine(); }
      p1 = new Player(name);
      if (gamePlayers == 2) {
         System.out.print("Player 2, enter your name: ");
         name = sc.nextLine();
         while (name.isEmpty() || name.equals(" ")) {
            System.out.print("Please enter your name: ");
            name = sc.nextLine(); }
         p2 = new Player(name); 
      }
   }
   
            
   void startGame() {
      int cards[][] , seconds , selectedOption;
      boolean coveredCards[][];
      int A[][]= { { 2 , 3 , 3 },
         		    { 3 , 4 , 4 },
         		    { 4 , 5 , 5 } };
      System.out.println("(1) Easy\n(2) Medium\n(3) Hard\nSelect from above: ");  
      OUTER_LOOP:
      while (true) {
         s = new Scanner(System.in); 
         INNER_LOOP:
         if (s.hasNextInt()) {
            selectedOption = s.nextInt(); 
            while(selectedOption != 1 && selectedOption != 2 && selectedOption != 3){
               System.out.print("Please enter 1 for Easy or 2 for Medium or 3 for Hard: ");
               if(s.hasNextInt()) {
                  selectedOption = s.nextInt();
                  break OUTER_LOOP; }
               else {
                  break INNER_LOOP; }
            }
            break; 
         }
      }
      cards = new int[A[selectedOption - 1][0]][A[selectedOption - 1][1]];
      coveredCards = new boolean[(A[selectedOption - 1][0])][(A[selectedOption - 1][1])];
      seconds = A[selectedOption - 1][2];
      initializeMatrices(cards , coveredCards);
      gameCooridinates(cards , coveredCards , seconds);
   }
   
   public void initializeMatrices(int cards[][] , boolean coveredCards[][] ) {
      int vector[] = test.shuffle(cards); 
      int x = 0;
      for (int r = 0; r < cards.length; r++) { 
         for (int c = 0; c < cards[0].length; c++) {
            cards[r][c] = vector[x];
            x++; }
      } 
      for (int r = 0; r <  cards.length; r++) {
         for (int c = 0; c < cards[0].length; c++) {
            coveredCards[r][c]=false; }
      }
   }

   public void gameCooridinates(int cards[][], boolean coveredCards[][] , int seconds) {
      boolean firstPlayer = true;
      System.out.println("\nYou have to enter two-digit number for one cooridinate, for example 11. The first digit is for row and the second one for column\n");
      int cards_numbers = cards.length * cards[0].length; //sa numra jane brenda matrices
      OUTER_LOOP:
      while (cards_numbers > 0) {
         if(firstPlayer) {
            player = p1.getName();
            firstPlayer = !firstPlayer;
         } else if(gamePlayers > 1){
            player = p2.getName();
            firstPlayer = !firstPlayer;
         }
         test1.displayBoard(cards , coveredCards);
         System.out.print(player.toUpperCase() + "\nEnter (M) if you want to go back in Menu\nEnter cooridinate 1 for the first card you want to open: ");
         String k1 = sc.nextLine();
         if(k1.toUpperCase().equals("M")) 
            break OUTER_LOOP;
      
         int koordinata1 = new Integer(k1).intValue();
         int k1_row = koordinata1 / 10;
         int k1_column = koordinata1 % 10;
         while( k1_column < 1 || k1_column > cards[0].length || k1_row < 1 || k1_row > cards.length || coveredCards[k1_row - 1][k1_column - 1] ) { 
            System.out.print("Please enter again cooridinate 1 beetween 1-" + cards.length + " for rows and 1-" + cards[0].length + " columns: ");
            koordinata1 = s.nextInt();
            k1_row = koordinata1 / 10;
            k1_column = koordinata1 % 10; 
         } 
         coveredCards[k1_row - 1][k1_column - 1] = true;  
         
         System.out.print("Enter row and column for the second card you want to open: ");
         String k2 = sc.nextLine();
         if(k2.toUpperCase().equals("M")) 
            break OUTER_LOOP;
            
         int koordinata2 = new Integer(k2).intValue();
         int k2_row = koordinata2 / 10;
         int k2_column = koordinata2 % 10;
         while(k2_column < 1 || k2_column > cards[0].length || k2_row < 1 || k2_row > cards.length || coveredCards[k2_row - 1][k2_column - 1] ) {
            System.out.print("Please enter again cooridinate 2 beetween 1-" + cards.length + " for rows and 1-" + cards[0].length + " columns: ");
            koordinata2 = s.nextInt(); 
            k2_row = koordinata2 / 10;
            k2_column = koordinata2 % 10; 
         }
         coveredCards[k2_row - 1][k2_column - 1] = true;
         
         if (cards[k1_row - 1][k1_column - 1] == cards[k2_row - 1][k2_column - 1]) {
            System.out.println("You found a match");
            cards_numbers-= 2;
            if(player.equals(p1.getName())) {
               p1.addOnePoint();
            } else {
               p2.addOnePoint();
            }
            firstPlayer = !firstPlayer;
         }
         else {
            try {
               System.out.println("Memorize the numbers");
               test1.displayBoard(cards, coveredCards);
               TimeUnit.SECONDS.sleep(seconds);
               coveredCards[k1_row - 1][k1_column - 1] = false;
               coveredCards[k2_row - 1][k2_column - 1] = false;
               test.cleanScreen(); 
            }
            catch (InterruptedException e) {
               e.printStackTrace();} 
         }
      }
      test1.displayBoard(cards, coveredCards);
      if (gamePlayers == 1) {
         System.out.println("GAME OVER!"); }
      else {
         System.out.println("GAME OVER!\nThe winner is: " + winner()); }
      while (true) {
         test1.displayEndMeny();
         s = new Scanner(System.in); 
         if(s.hasNextInt()) {
            int selectedOption = s.nextInt();
            while (selectedOption > 3 || selectedOption < 0) {
               System.out.print("Please enter 1 or 2 or 3: ");
               if(s.hasNextInt()) {
                  selectedOption = s.nextInt();
               } else { 
                  break; }
            }
            gameOption2(selectedOption);
         
            if (selectedOption == 1) 
               break;
            else if (selectedOption == 3) {
               System.out.println("Exiting game");
               break; }
         }
      }
   }

}