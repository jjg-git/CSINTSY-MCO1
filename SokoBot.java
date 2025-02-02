package solver;

public class SokoBot {
   // Hi I edited.
   private int[2] playerCoordinate;
   private int numOfGoals = 0;
   private int[][] goals;
   private int numOfCrates = 0;
   private int[][] crates;
   private int numOfWalls = 0;
   private int[][] walls;
   private boolean up = true, down = true, left = true, right = true;
   private int move = 1, prevMove;

   /*checks if player can move*/
   public void checkWall(){
      for (int checking = 0; checking < walls.length; checking++){
         if (playerCoordinate[0]+move == walls[checking][0]){ //wall right of player
            right = false;
         }
         if (playerCoordinate[1]+move == walls[checking][1]){ //wall above player
            up = false;
         }
         if (playerCoordinate[0]-move == walls[checking][0]){ //wall left of player
            left = false;
         }
         if (playerCoordinate[1]-move == walls[checking][1]){ //wall below player
            down = false;
         }
      }
   }

      /*Checks if crates can move*/
   public void checkCrate(){
      for (int checking = 0; checking < crates.length; checking++){
         if (playerCoordinate[0]+move == crates[checking][0]){ //crate right of player
            move = 2;
         }
         if (playerCoordinate[1]+move == crates[checking][1]){ //crate above player
            move = 2;
         }
         if (playerCoordinate[0]-move == crates[checking][0]){ //crate left of player
            move = 2;
         }
         if (playerCoordinate[1]-move == crates[checking][1]){ //crate below player
            move = 2;
         }
         switch(move){ //to check for walls around the path of the crate
            case 2: checkWall();
         }
      }
   }
      

  /*Responsible for the movement of player
  @param playerCoordinate coordinate of player
  @param crates array of coordinates of crates
  @param goals array of coordinates of goals
  @param prevMove checks previous move made (-1 means no previous moves made)
  */
   
  public String movement(int[] playerCoordinate, int[][] crates, int[][] goals, int prevMove){
      checkWall(); //Checks for walls on all possible moves
      checkCrate(); //Checks for crates on all possible moves and for walls next to those crates
     
      switch(prevMove){ //Checks for previous moves to avoid repeating moves
         case 0: up = false;break;
         case 1: down = false;break;
         case 2: left = false;break;
         case 3: right = false; break;
      }
     //Enters the if statements where it can go
      if(up == true){
         playerCoordinate[1]++; //coordinate of player
         prevMove = 0; //lets program know that this was the move made for the next move
         movement(playerCoordinate, crates, goals, prevMove); //recursion for the next moves
      }
      if(down == true){
         playerCoordinate[1]--;
         prevMove = 1;
         movement(playerCoordinate, crates, goals, prevMove);
         
      }
      if(left == true){
         playerCoordinate[0]--;
         prevMove = 2;
         movement(playerCoordinate, crates, goals, prevMove);
      }
      if(right == true){
         playerCoordinate[0]++;
         prevMove = 3;
         movement(playerCoordinate, crates, goals, prevMove);
      }
  }
  public String solveSokobanPuzzle(int width, int height, char[][] mapData, char[][] itemsData) {
    /*
     * YOU NEED TO REWRITE THE IMPLEMENTATION OF THIS METHOD TO MAKE THE BOT SMARTER
     */
    /*
     * Default stupid behavior: Think (sleep) for 3 seconds, and then return a
     * sequence
     * that just moves left and right repeatedly.
     */
   
    /*To identify the coordinates of all solid objects that is not an empty space*/
    for(int i = 0; i < height; i++){ 
      for(int j = 0; j < width; j++){
        if(itemsData[i][j] == '@'){ //coordinates of player at start
          playerCoordinate[0] = j;
          playerCoordinate[1] = i;
        }
        if(itemsData[i][j] == '$'){ //coordinates of crates/boxes
          crates[crates.length][0] = j;
          crates[crates.length][1] = i;
        }
        if(mapData[i][j] == '.'){ //coordinates of goals
          goals[goals.length][0] = j;
          goals[goals.length][1] = i;
        }
        if(mapData[i][j] == '#'){ //coordinates of walls
          walls[walls.length][0] = j;
          walls[walls.length][1] = i;
        }
      }
    }
    prevMove = -1; //signifies that this is the first move to be made by player or that no moves have been previously made
    movement(playerCoordinate, crates, goals, prevMove);
    try {
      Thread.sleep(3000);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return "lrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlr";
  }

}
