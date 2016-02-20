package lesson1.home02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Tirex on 20.02.2016.
 */
public class Solution {
    public static void main(String[] args) throws IOException {
        Point p1 = new Point();
        Point p2 = new Point();
        BufferedReader inp = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите координаты перовй точки в двумерной плоскости (x,y):");
        p1.x = Integer.parseInt(inp.readLine());
        p1.y = Integer.parseInt(inp.readLine());
        System.out.println("Введите координаты второй точки в двумерной плоскости (x,y):");
        p2.x = Integer.parseInt(inp.readLine());
        p2.y = Integer.parseInt(inp.readLine());

        System.out.println(distance(p1, p2));


    }

    public static double distance(Point p1, Point p2) {

        return Math.sqrt((p1.x - p2.x)*(p1.x - p2.x) + (p1.y - p2.y)*(p1.y - p2.y));
    }
}
