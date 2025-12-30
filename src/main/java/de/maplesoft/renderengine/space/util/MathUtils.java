package de.maplesoft.renderengine.space.util;

public class MathUtils {
    public static final double RAD2ANGLES = 180/Math.PI;

    public static double sin(double degrees) {
        return Math.sin(degrees * RAD2ANGLES);
    }

    public static double lossySin(double degrees) {
        return reduceAngle(degrees); // sin(x) ~= x
    }

    public static double reduceAngle(double degrees) {
        while (degrees >= 360)
            degrees -= 360;

        while (degrees < 0)
            degrees += 360;

        return degrees;
    }
}
