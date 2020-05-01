package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
     static ArrayList<Point> points = new ArrayList<>();
     static ArrayList<Point> visitedPoints = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {
        Scanner s = new Scanner(new File("C:\\Users\\mehrab\\Desktop\\javaScript\\filename.txt"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        double min = Double.MAX_VALUE;
        int n;
        n = Integer.parseInt(list.get(0));
        System.out.println(n);
        for (int i = 1; i < n * 2; i++) {
            points.add(new Point(Integer.parseInt(list.get(i)),Integer.parseInt(list.get(i + 1))));
            i++;
        }

        Point curuntPoint = null;
        long lang1 = System.nanoTime();
        points.get(0).visited = true;
        Point firstPoint = points.get(0);
        visitedPoints.add(firstPoint);
        curuntPoint = findNearestPoint(firstPoint);

        for (int i = 0; i < n - 2; i++) {
            curuntPoint = findNearestPoint(curuntPoint);
        }
        long lang2 = System.nanoTime();
        System.out.println(lang2 - lang1);
        System.out.println("result is :");
        for (int i = 0; i < n; i++) {
            System.out.println(visitedPoints.get(i).x + " " + visitedPoints.get(i).y);
        }

    }

    public static Point findNearestPoint(Point pt){
        Point nearest = null;
        double min = Double.MAX_VALUE;
        int i = -1;
        for (int k = 0; k < points.size(); k++) {
            if (!points.get(k).equals(pt) && !points.get(k).visited && pt.distance(points.get(k)) < min) {
                min = pt.distance(points.get(k));
                nearest = points.get(k);
                i = k;
            }
        }
        visitedPoints.add(nearest);
        points.get(i).visited = true;
        return nearest;
    }


}
