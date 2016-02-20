package lesson1.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Tirex on 20.02.2016.
 */
public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите координаты перовй точки в двумерной плоскости (x,y):");
        int p1x = Integer.parseInt(inp.readLine());
        int p1y = Integer.parseInt(inp.readLine());
        Point p1 = new Point(p1x, p1y);

        System.out.println("Введите координаты второй точки в двумерной плоскости (x,y):");
        int p2x = Integer.parseInt(inp.readLine());
        int p2y = Integer.parseInt(inp.readLine());
        Point p2 = new Point(p2x, p2y);

        Point l = new Point(p1, p2);

        System.out.println(l.distance(p1, p2));


    }

}
