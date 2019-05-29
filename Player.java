public class Player {
   private  String name = "";
   private  int points = 0;

   Player(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public String toString() {
      return this.name + " has " + getPoints() + " points";
   }
   
   public  void addOnePoint() {
      this.points++;
   }

   public int getPoints() {
      return this.points;
   }


}