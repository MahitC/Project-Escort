import java.awt.*;
import java.util.*;
import javax.swing.*;


public class GUI extends JFrame {

    public GUI(String[][] matrix) {
        super("Matrix Display");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JTable table = new JTable(matrix.length, matrix[0].length);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                table.setValueAt(matrix[i][j], i, j);
            }
        }
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    public static void addItem(String[][] board, int[] loc, String name){
        board[loc[0]][loc[1]] = name;
    }
    
    public static void removeItem(String[][] board,int[]loc){
        board[loc[0]][loc[1]] = "";
    }
    
    public static boolean gameOver() {
    	return false;
    }

    public static void main(String[] args) {
    	Scanner keyboard=new Scanner(System.in);
    	System.out.println("Get the supply wagon (troop 6) to go directly across where it is now!");
        String[][] matrix = {{"", "", "", "", "", ""}, {"troop1", "", "barrier", "", "", ""}, {"", "troop2", "", "barrier", "enemy1", "enemy2"}, {"wagon", "troop3", "", "barrier", "enemy3", ""}, {"barrier", "troop4", "", "enemy4", "", ""}, {"troop5", "", "", "barrier", "enemy5", ""}, {"", "barrier", "", "", "", ""}};
        Troop troop1=new Troop(35, 100, 1, 0, "troop 1");
        Troop troop2=new Troop(35, 100, 2, 1, "troop 2");
        Troop troop3=new Troop(35, 100, 3, 1, "troop 3");
        Troop troop4=new Troop(35, 100, 4, 1, "troop 4");
        Troop troop5=new Troop(35, 100, 5, 0, "troop 5");
        Troop wagon=new Troop(0, 150, 3, 1, "wagon");
        Troop[] troops= {troop1, troop2, troop3,troop4, troop5, wagon};
        
        Troop enemy1=new Troop(35, 100, 0, 0, "enemy 1");
        Troop enemy2=new Troop(35, 100, 0, 0, "enemy 2");
        Troop enemy3=new Troop(35, 100, 0, 0, "enemy 3");
        Troop enemy4=new Troop(35, 100, 0, 0, "enemy 4");
        Troop enemy5=new Troop(35, 100, 0, 0, "enemy 5");
        Troop[] enemies= {enemy1, enemy2, enemy3, enemy4, enemy5};
        
        while(wagon.getLoc()[0]!=5 || wagon.getLoc()[1]!=3) {
        	GUI gui=new GUI(matrix);
        	System.out.println("1: attack\n2: move\n3: endturn");
        	int option=keyboard.nextInt();
        	if(option==1) {
        		System.out.println("pick a troop");
        		int troop=keyboard.nextInt()-1;
        		while(troop<0 || troop>5) {
        			System.out.println("invalid troop. re-enter troop number");
        			troop=keyboard.nextInt()-1;
        		}
        		System.out.println("pick an enemy");
        		int enemy=keyboard.nextInt()-1;
        		while(enemy<0 || enemy>4) {
        			System.out.println("invalid troop. re-enter troop number");
        			troop=keyboard.nextInt()-1;
        		}
        		troops[troop].attack(enemies[enemy]);
        	} else if(option==2) {
        		System.out.println("pick a troop");
        		int troop=keyboard.nextInt()-1;
        		while(troop<0 || troop>5) {
        			System.out.println("invalid troop. re-enter troop number");
        			troop=keyboard.nextInt()-1;
        		}
        		System.out.println("move forward or backward or nowwhere(1,-1, 0)");
        		int x=keyboard.nextInt();
        		System.out.println("move up, down or nowhere(-1, 1, 0)");
        		int y=keyboard.nextInt();
        		while(troops[troop].getLoc()[1]+x>5 || troops[troop].getLoc()[1]+x<0 || troops[troop].getLoc()[0]+y>6 || troops[troop].getLoc()[0]+y<0 || !matrix[troops[troop].getLoc()[0]+x][troops[troop].getLoc()[1]+y].equals("")) {
        			System.out.println("invalid. move up, down or nowhere(-1, 1, 0)");
            		x=keyboard.nextInt();
            		y=keyboard.nextInt();
        		}
        		removeItem(matrix, troops[troop].getLoc());
        		troops[troop].move(x, y);
        		addItem(matrix, troops[troop].getLoc(), troops[troop].getName());
        	}
        	System.out.println("Your turn ended. Enemy moving.");
        	option=(int) (Math.random()*2+1);
        	if(option==1) {
        		System.out.println("pick a troop");
        		int troop=(int)(Math.random()*5);
        		while(troop<0 || troop>5) {
        			System.out.println("invalid troop. re-enter troop number");
        			troop=(int)(Math.random()*5);
        		}
        		System.out.println("pick an enemy");
        		int enemy=keyboard.nextInt()-1;
        		while(enemy<0 || enemy>4) {
        			System.out.println("invalid troop. re-enter troop number");
        			troop=(int)(Math.random()*5);
        		}
        		troops[troop].attack(enemies[enemy]);
        	} else if(option==2) {
        		System.out.println("pick a troop");
        		int troop=(int)(Math.random()*5);
        		while(troop<0 || troop>5) {
        			System.out.println("invalid troop. re-enter troop number");
        			troop=(int)(Math.random()*5);
        		}
        		System.out.println("move forward or backward or nowwhere(1,-1, 0)");
        		int x=(int)(Math.random()*3-1);
        		System.out.println("move up, down or nowhere(-1, 1, 0)");
        		int y=(int)(Math.random()*3-1);
        		while(troops[troop].getLoc()[1]+x>5 || troops[troop].getLoc()[1]+x<0 || troops[troop].getLoc()[0]+y>6 || troops[troop].getLoc()[0]+y<0 || !matrix[troops[troop].getLoc()[0]+x][troops[troop].getLoc()[1]+y].equals("")) {
        			System.out.println("invalid. move up, down or nowhere(-1, 1, 0)");
            		x=(int)(Math.random()*3-1);
            		y=(int)(Math.random()*3-1);
        		}
        		removeItem(matrix, troops[troop].getLoc());
        		troops[troop].move(x, y);
        		addItem(matrix, troops[troop].getLoc(), troops[troop].getName());
        	}
        	gui.dispose();
        }
    }
}
