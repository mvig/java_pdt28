package lesson1.home02;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Tirex on 25.02.2016.
 */
public class TestLength3 {
    @Test
    public void testLenght3() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(4, 2);
        Point l = new Point(p1, p2);
        Point p3 = new Point(2, 0);
        Point p4 = new Point(4, 0);
        Point l2 = new Point(p3, p4);

        Assert.assertEquals(l.distance(p1, p2), l2.distance(p3, p4));
    }
}
