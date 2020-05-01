package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws IOException {

        ArrayList<Point> arrayList = new ArrayList<>();
        Random randomn = new Random();
        int nR = randomn.nextInt(6) + 5;
        for (int i = 0; i < nR; i++) {
            arrayList.add(new Point(randomn.nextInt(100),randomn.nextInt(100)));
        }
        FileReading fileReading = new FileReading(arrayList);
    }
}
