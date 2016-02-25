package lesson1.home02;

import org.testng.annotations.Test;

/**
 * Created by Tirex on 25.02.2016.
 */

public class TestPointTest {

@Test
public void testLenght() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(4, 4);
        Point l = new Point(p1, p2);

        assert l.distance(p1, p2) == 4;
    }

}