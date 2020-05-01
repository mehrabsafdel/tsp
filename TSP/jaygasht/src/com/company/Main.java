package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    static ArrayList<Point> points = new ArrayList<>();
    static ArrayList<Point> best = new ArrayList<>();

    public static void main(String[] args) throws IOException {
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

        long lang = System.nanoTime();
        ArrayList<ArrayList<Point>> mamad = findPermute(points);

        for (int i = 0; i < mamad.size(); i++) {
            if (caclcuteDistance(mamad.get(i) ) < min){
                min = caclcuteDistance(mamad.get(i));
                best = mamad.get(i);
            }
        }
        long lang2 = System.nanoTime();
        System.out.println(lang2 - lang);
        System.out.println("the best way is :");
        for (int i = 0; i < n; i++) {
            System.out.println(best.get(i).x + " " + best.get(i).y);
        }

    }

    public static double caclcuteDistance(ArrayList<Point> pts){
        double distance = 0;
        for (int i = 0; i < pts.size() - 1; i++) {
            distance += Math.sqrt(Math.pow(pts.get(i).x - pts.get(i + 1).x,2) + Math.pow(pts.get(i).y - pts.get(i + 1).y,2));
        }

        return distance;
    }
    private static ArrayList<ArrayList<Point>> findPermute(List<Point> points) {
        ArrayList<ArrayList<Point>> result = new ArrayList<>();
        //start from an empty list
        result.add(new ArrayList<>());
        for (Point location : points) {
            //list of list in current iteration of the array num
            ArrayList<ArrayList<Point>> current = new ArrayList<>();

            for (ArrayList<Point> l : result) {
                // # of locations to insert is largest index + 1
                for (int j = 0; j < l.size() + 1; j++) {
                    // + add num[i] to different locations
                    l.add(j, location);

                    ArrayList<Point> temp = new ArrayList<>(l);
                    current.add(temp);

                    // - remove num[i] add
                    l.remove(j);
                }
            }
            result = new ArrayList<>(current);
        }
        return result;
    }
}
