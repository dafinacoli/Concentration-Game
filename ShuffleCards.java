import java.util.*;
public class ShuffleCards {
   static Random random = new Random();
   public static int[] shuffle(int cards[][]) {
      int x = cards.length*cards[0].length;
      int count1 = 1;
      int count2 = 1;
      int vector[] = new int[x]; // this vector has n*m numbers
      for(int i = 0; i < x/2; i++) {
         vector[i] = count1;
         count1++;
      }
      for(int i = x/2; i < x; i++) {
         vector[i] = count2;
         count2++;
      }
   
      for (int i = 0; i < x; i++) { 
         int j = (int)(Math.random() * x);
         int temp = vector[i];
         vector[i] = vector[j];
         vector[j] = temp;
      }

      return vector;
   }      
   public final static void cleanScreen() {
      System.out.print("\033[H\033[2J");
      System.out.flush();
   }


}