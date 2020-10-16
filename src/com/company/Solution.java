package com.company;
import java.util.*;

public class Solution {
    public static void log(String s)
    {
        System.out.println(s);
    }
    public static void logl(String s)
    {
        System.out.print(s);
    }
    public static void log(List<String> s)
    {
        System.out.println(s);
    }
    public static void enterA(int n,int[][] a)
    {   Scanner in = new Scanner(System.in);
        for(int i=0 ; i<n ; i++)
        {
            for(int j=0 ; j<n ; j++) {
             a[i][j]=in.nextInt();
            }
        }
    }
    public static void enterA(int n,String[][] a,int[][] b)
    {   Scanner in = new Scanner(System.in);
        for(int i=0 ; i<n ; i++)
        {
            for(int j=0 ; j<n ; j++) {
                if(b[i][j]==1)
                    a[i][j]="=";
                else
                    a[i][j]="N";
            }
        }
    }
    public static void prA(int n,String[][] a)
    {
        for(int i=0 ; i<n ; i++)
        {
            for(int j=0 ; j<n ; j++) {
                if(a[i][j].equals("N") || a[i][j].equals("C"))
                    System.out.print("\t");
                else
                    System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void prA(int n,int[][] a)
    {
        for(int i=0 ; i<n ; i++)
        {
            for(int j=0 ; j<n ; j++) {
                if(a[i][j]!=0)
                    System.out.print(a[i][j]+"\t");
                else
                    System.out.print("\t");
            }
            System.out.println();
        }
    }
    public static int dist(int a, int b, int c, int d)
    {
        return (int)(10*(Math.sqrt(Math.pow(a-c,2)+Math.pow(b-d,2))));
    }
    public static ArrayList<ArrayList<Integer>> dist(int[][] arr,String[][] brr,int a, int b, int xs,int ys,int xe, int ye,ArrayList<ArrayList<Integer>> ll)
    {   int Gcost,Hcost,Fcost;
        brr[a][b]="V";
        ArrayList<Integer> l;
        try {
            l= new ArrayList<Integer>();
            if(brr[a-1][b-1].equals("N")) {
                Gcost = dist(a - 1, b - 1, xs, ys);
                Hcost = dist(a - 1, b - 1, xe, ye);
                Fcost = Gcost + Hcost;
                arr[a - 1][b - 1] = Fcost;
                l.add(Fcost);
                l.add(a-1);
                l.add(b-1);
                ll.add(l);
                brr[a-1][b-1]="C";
            }
            else if(brr[a-1][b-1].equals("O")) {
                l.add(0);
                l.add(a-1);
                l.add(b-1);
                ll.add(0,l);
                brr[a-1][b-1]="V";
                return ll;
            }
        }catch(Exception e){}
        try {
            l= new ArrayList<Integer>();
            if(brr[a][b-1].equals("N")) {
                Gcost = dist(a, b - 1, xs, ys);
                Hcost = dist(a, b - 1, xe, ye);
                Fcost = Gcost + Hcost;
                arr[a][b - 1] = Fcost;
                l.add(Fcost);
                l.add(a);
                l.add(b-1);
                ll.add(l);
                brr[a][b-1]="C";
            }
            else if(brr[a][b-1].equals("O")) {
                l.add(0);
                l.add(a);
                l.add(b-1);
                ll.add(0,l);
                brr[a][b-1]="V";
                return ll;
            }
        }catch(Exception e){}
        try {
            l= new ArrayList<Integer>();
            if(brr[a+1][b-1].equals("N")) {
                Gcost=dist(a+1,b-1,xs,ys);
                Hcost=dist(a+1,b-1,xe,ye);
                Fcost=Gcost+Hcost;
                arr[a+1][b-1]=Fcost;
                l.add(Fcost);
                l.add(a+1);
                l.add(b-1);
                ll.add(l);
                brr[a+1][b-1]="C";
            }
            else if(brr[a+1][b-1].equals("O")) {
                l.add(0);
                l.add(a+1);
                l.add(b-1);
                ll.add(0,l);
                brr[a+1][b-1]="V";
                return ll;
            }
        }catch(Exception e){}
        try {
            l= new ArrayList<Integer>();
            if(brr[a+1][b].equals("N")) {
                Gcost = dist(a + 1, b, xs, ys);
                Hcost = dist(a + 1, b, xe, ye);
                Fcost = Gcost + Hcost;
                arr[a + 1][b] = Fcost;
                l.add(Fcost);
                l.add(a+1);
                l.add(b);
                ll.add(l);
                brr[a+1][b]="C";
            }
            else if(brr[a+1][b].equals("O")) {
                l.add(0);
                l.add(a+1);
                l.add(b);
                ll.add(0,l);
                brr[a+1][b]="V";
                return ll;
            }
        }catch(Exception e){}
        try {
            l= new ArrayList<Integer>();
            if(brr[a+1][b+1].equals("N")) {
                Gcost = dist(a + 1, b + 1, xs, ys);
                Hcost = dist(a + 1, b + 1, xe, ye);
                Fcost = Gcost + Hcost;
                arr[a + 1][b + 1] = Fcost;
                l.add(Fcost);
                l.add(a+1);
                l.add(b+1);
                ll.add(l);
                brr[a+1][b+1]="C";
            }
            else if(brr[a+1][b+1].equals("O")) {
                l.add(0);
                l.add(a+1);
                l.add(b+1);
                ll.add(0,l);
                brr[a+1][b+1]="V";
                return ll;
            }
        }catch(Exception e){}
        try {
            l= new ArrayList<Integer>();
            if(brr[a][b+1].equals("N")) {
                Gcost = dist(a, b + 1, xs, ys);
                Hcost = dist(a, b + 1, xe, ye);
                Fcost = Gcost + Hcost;
                arr[a][b + 1] = Fcost;
                l.add(Fcost);
                l.add(a);
                l.add(b+1);
                ll.add(l);
                brr[a][b+1]="C";
            }
            else if(brr[a][b+1].equals("O")) {
                l.add(0);
                l.add(a);
                l.add(b+1);
                ll.add(0,l);
                brr[a][b+1]="V";
                return ll;
            }
        }catch(Exception e){}
        try {
            l= new ArrayList<Integer>();
            if(brr[a-1][b+1].equals("N")) {
                Gcost = dist(a - 1, b + 1, xs, ys);
                Hcost = dist(a - 1, b + 1, xe, ye);
                Fcost = Gcost + Hcost;
                arr[a - 1][b + 1] = Fcost;
                l.add(Fcost);
                l.add(a-1);
                l.add(b+1);
                ll.add(l);
                brr[a-1][b+1]="C";
            }
            else if(brr[a-1][b+1].equals("O")) {
                l.add(0);
                l.add(a-1);
                l.add(b+1);
                ll.add(0,l);
                brr[a-1][b+1]="V";
                return ll;
            }
        }catch(Exception e){}
        try {
            l= new ArrayList<Integer>();
            if(brr[a-1][b].equals("N")) {
                Gcost = dist(a - 1, b, xs, ys);
                Hcost = dist(a - 1, b, xe, ye);
                Fcost = Gcost + Hcost;
                arr[a - 1][b] = Fcost;
                l.add(Fcost);
                l.add(a-1);
                l.add(b);
                ll.add(l);
                brr[a-1][b]="C";
            }
            else if(brr[a-1][b].equals("O")) {
                l.add(0);
                l.add(a-1);
                l.add(b);
                ll.add(0,l);
                brr[a-1][b]="V";
                return ll;
            }
        }catch(Exception e){}
        Collections.sort(ll, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> o1, ArrayList<Integer> o2) {
                return o1.get(0).compareTo(o2.get(0));
            }
        });
        return ll;
    }
    public static void astar(int n,String[][] brr,int[][] arr, int xs,int ys,int xe, int ye,ArrayList<ArrayList<Integer>> ll)
    {
        dist(arr,brr,xs,ys,xs,ys,xe,ye,ll);
        while(true)
        {
            System.out.print((char) 8);
            try {
            int a = ll.get(0).get(1);
            int b = ll.get(0).get(2);
            if ((a == xe && b == ye)) {
                break;
            }
            ll.remove(0);
            //TimeUnit.MILLISECONDS.sleep(1);
            dist(arr, brr, a, b, xs, ys, xe, ye, ll);
        }
        catch(Exception e)
        {
            log("NO SOLUTION");
            break;
        }
        }
    }
    public static void main() {
        Scanner in = new Scanner(System.in);
        log("Size of array");
        ArrayList<ArrayList<Integer>> ll= new ArrayList<ArrayList<Integer>>();
        int n=in.nextInt();
        log("Start point");
        int xs=in.nextInt();
        int ys=in.nextInt();
        log("End point");
        int xe=in.nextInt();
        int ye=in.nextInt();
        if(Math.sqrt(Math.pow(xs-n/2,2)+Math.pow(ys-n/2,2))<Math.sqrt(Math.pow(xe-n/2,2)+Math.pow(ye-n/2,2))){
            int temp=xs;
            xs=xe;
            xe=temp;
            temp=ys;
            ys=ye;
            ye=temp;
        }
        int a[][]=new int[n][n];
        String b[][]=new String[n][n];
        MazeGenerator mazeGenerator = new MazeGenerator(n);
        mazeGenerator.generateMaze();
        System.out.println("RAW MAZE\n" + mazeGenerator.getRawMaze().replace("[","").replace("]","").replace(",",""));
        log("Enter Array 1=Wall 0=Path");
        enterA(n,a);
        a[xs][ys]=-1;
        a[xe][ye]=-1;
        enterA(n,b,a);
        b[xs][ys]="O";
        b[xe][ye]="O";
        if(xs==xe && ys==ye)
        {
            b[xs][ys]="V";
            return;
        }
        Map.astar(n,b,a,xs,ys,xe,ye,ll);
    }
}


