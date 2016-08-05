package main;

import org.junit.Ignore;
import org.junit.Test;

import static java.lang.Math.PI;
import static java.lang.Math.sqrt;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by sda on 6/5/16.
 */
public class TestCircle {

    private final double[] validRadiuses = {0.d, 1.0d, 50.d, 1005.5d};

    private final double inaccuracyCompare = 1E-6;

    private final double[] invalidRadiuses = {-105.5d, -1.d, Double.MIN_VALUE, Double.MAX_VALUE,
            Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY
    };

    @Test
    public void testCreateValidCircle() {
        for (double validRadius : validRadiuses) {
            new Circle(validRadius);
        }
    }

    //Uncommented after fixed constructor
    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void testFailedCreateCircle() {
        for (double validRadius : invalidRadiuses) {
            Circle circle = new Circle(validRadius);
        }
    }

    @Test
    public void testCalculateSquare() {
        for (double validRadius : validRadiuses) {
            Circle circle = new Circle(validRadius);
            double square = circle.squareCircle();
            double calcRadius = sqrt(square / PI);
            assertEquals(validRadius, calcRadius, inaccuracyCompare);
        }
    }

    @Test
    public void testEqualsSquare() {
        for (double validRadius : validRadiuses) {
            Circle circle1 = new Circle(validRadius);
            Circle circle2 = new Circle(validRadius);
            assertTrue(circle1.equalsCircle(circle2));
        }
    }

    @Test(expected = NullPointerException.class)
    public void testInvalidArgumentsEqualsSquare() {
        Circle circle = new Circle(validRadiuses[0]);
        circle.equalsCircle(null);
    }
}
