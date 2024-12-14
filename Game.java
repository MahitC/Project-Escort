public class Game {
    public static void main(String[] args) throws Exception {
       String[][] board = new String[7][6];
        System.out.println("Hello, World!");
        int cash = 100;
        int[] loc = {1,2};
        Troop troop = new Troop(35,100, loc, "Rifleman");
        System.out.println(cash);
    }

    public void addItem(String[][] board, int[]loc, String name){
        board[loc[0]][loc[1]] = name;
    }
    public static void removeItem(String[][] board,int[]loc){
        board[loc[0]][loc[1]] = "";
    }
}
