public class Troop {
   private int damage;
   private int hp;
   private int[] loc;
   private boolean hasMoved;
   private boolean canAttack;
   private String name;
    public Troop(int damage, int hp, int col, int row, String name){
            this.damage=damage;
            this.hp = hp;
            this.name = name;
            loc = new int[2];
            loc[0] = row;
            loc[1] = col;
    }
    public String getName(){
        return name;
    }
    public int getHP(){
        return hp;
    }
    public void allowAttack(){
        canAttack = true;
    }
    public boolean isInRange(int col, int row){
        if(Math.abs(loc[0]-col)>1){
            return false;
        }
        if(Math.abs(loc[1]-row)>1){
            return false;
        }
        return true;
    }
    public void attack (Troop enemy){

        if(isInRange(enemy.loc[0], enemy.loc[1])){
            enemy.hp-= damage; 
        }
            
    }
    public boolean isDead(){
        if(hp<=0){
            return true;
        }
        return false;
    }
    public int[] getLoc(){
        return loc;
    }

    public void allowMove(){
        hasMoved = false;
    }
    public boolean canMove(int col, int row){
        if(col>1||col<-1){
            col = col/Math.abs(col);
        }
        if(row>1||row<-1){
            row = row/Math.abs(row);
        }
        return true;
    }
    public void move(int col, int row){
        if(canMove(col,row)){
            loc[0] += row;
            loc[1] += col;
        }
        
    }
    
}
