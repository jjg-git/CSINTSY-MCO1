package solver;

public class SokoBot {

  public String solveSokobanPuzzle(int width, int height, char[][] mapData, char[][] itemsData) {
    /*
     * YOU NEED TO REWRITE THE IMPLEMENTATION OF THIS METHOD TO MAKE THE BOT SMARTER
     */
    /*
     * Default stupid behavior: Think (sleep) for 3 seconds, and then return a
     * sequence
     * that just moves left and right repeatedly.
     */
    int xOfPlayer;
    int yOfPlayer;
      for(int i = 0; i < height; i++){
      for(int j = 0; j < width; j++){
        if(itemsData[i][j] == '@'){
          xOfPlayer = j;
          yOfPlayer = i;
      }
    }
    for(int y = 0; y < height; y++){
      for(int x = 0;x < width; x++){
        
      }
    }
    try {
      Thread.sleep(3000);
    } catch (Exception ex) {
      ex.printStackTrace();
    }
    return "lrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlrlr";
  }

}
