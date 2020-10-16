package com.company;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Map extends JPanel {

    public static final Color empty = new Color(255, 255, 255);
    public static final Color visited = new Color(255, 60, 68);
    public static final Color calculated = new Color(51,153,0);
    public static final Color path = new Color(61, 186, 255);
    public static final Color wall = new Color(0, 0,0);
    public static final Color goals = new Color(255, 219,0);
    public static final Color[] TERRAIN = {empty,visited,calculated,path,wall,goals};
    public static int[][] arr;
    public static int NUM_ROWS=0;
    public static int NUM_COLS=0;
    public static int PREFERRED_GRID_SIZE_PIXELS = 2;

    // In reality you will probably want a class here to represent a map tile,
    // which will include things like dimensions, color, properties in the
    // game world.  Keeping simple just to illustrate.
    private final Color[][] terrainGrid;
    public static void log(String s)
    {
        System.out.println(s);
    }
    public static void astar(int n,String[][] brr,int[][] arr, int xs,int ys,int xe, int ye,ArrayList<ArrayList<Integer>> ll)
    {   JFrame frame=new JFrame("Game");
        NUM_ROWS=n;
        NUM_COLS=n;
        Solution.dist(arr,brr,xs,ys,xs,ys,xe,ye,ll);
        while(true)
        {
            SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Map map = new Map(arr,brr);
                frame.add(map);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.pack();
                frame.setVisible(true);
            }
        });
            try {
                int a = ll.get(0).get(1);
                int b = ll.get(0).get(2);
                if ((a == xe && b == ye)) {
                    break;
                }
                ll.remove(0);
                System.out.println(ll);
                TimeUnit.MILLISECONDS.sleep(5);
                Solution.dist(arr, brr, a, b, xs, ys, xe, ye, ll);
            }
            catch(Exception e)
            {
                log("NO SOLUTION");
                break;
            }
        }
    }
    public Map(int[][] arr,String[][] brr){
        this.terrainGrid = new Color[NUM_ROWS][NUM_COLS];
        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                Color randomColor=TERRAIN[3];
                if(arr[i][j]==1) {
                    randomColor = TERRAIN[4];
                }
                if(brr[i][j]=="C") {
                    randomColor = TERRAIN[2];
                }
                if(brr[i][j]=="V") {
                    randomColor = TERRAIN[1];
                }
                if(arr[i][j]==-1) {
                    randomColor = TERRAIN[5];
                }
                this.terrainGrid[i][j] = randomColor;
            }
        }
        int preferredWidth = NUM_COLS * PREFERRED_GRID_SIZE_PIXELS;
        int preferredHeight = NUM_ROWS * PREFERRED_GRID_SIZE_PIXELS;
        setPreferredSize(new Dimension(preferredWidth, preferredHeight));
    }
    @Override
    public void paintComponent(Graphics g) {
        // Important to call super class method
        //super.paintComponent(g);
        // Clear the board
        g.clearRect(0, 0, getWidth(), getHeight());
        // Draw the grid
        int rectWidth = getWidth() / NUM_COLS;
        int rectHeight = getHeight() / NUM_ROWS;

        for (int i = 0; i < NUM_ROWS; i++) {
            for (int j = 0; j < NUM_COLS; j++) {
                // Upper left corner of this terrain rect
                int x = i * rectWidth;
                int y = j * rectHeight;
                Color terrainColor = terrainGrid[j][i];
                g.setColor(terrainColor);
                g.fillRect(x, y, rectWidth, rectHeight);
                g.setColor(empty);
                try {
                    g.drawString(arr[i][j] + "", x + PREFERRED_GRID_SIZE_PIXELS / 2, y + PREFERRED_GRID_SIZE_PIXELS / 2);
                }
                catch (Exception e){}
            }
        }
    }
    public static void main(String[] args) {
        Solution.main();
    }
}