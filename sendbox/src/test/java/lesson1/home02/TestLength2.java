package lesson1.home02;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Tirex on 25.02.2016.
 */
public class TestLength2 {
    @Test
    public void testLenght2() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 0);
        Point l = new Point(p1, p2);

        Assert.assertEquals(l.distance(p1, p2), 0.0);
    }
}
