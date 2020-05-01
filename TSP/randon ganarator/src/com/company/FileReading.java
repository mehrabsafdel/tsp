package com.company;


import java.io.*;
import java.util.ArrayList;

public class FileReading {

    public FileReading(ArrayList<Point> points) throws IOException {
        BufferedWriter outputWriter = null;
        outputWriter = new BufferedWriter(new FileWriter("C:\\Users\\mehrab\\Desktop\\javaScript\\filename.txt"));
        outputWriter.write(points.size() + "");
        outputWriter.newLine();

        for (int i = 0; i < points.size(); i++) {
            // Maybe:
            outputWriter.write(points.get(i).x+" "+points.get(i).y);
            // Or:
            // outputWriter.write(Integer.toString(x.get(i)));
            outputWriter.newLine();
        }
        outputWriter.flush();
        outputWriter.close();
    }
}
