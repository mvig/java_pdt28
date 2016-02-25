package lesson1.home02;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Tirex on 25.02.2016.
 */

public class TestLength1 {

@Test
public void testLength() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(4, 4);
        Point l = new Point(p1, p2);

    Assert.assertEquals(l.distance(p1, p2), 2.8284271247461903);
    }


}