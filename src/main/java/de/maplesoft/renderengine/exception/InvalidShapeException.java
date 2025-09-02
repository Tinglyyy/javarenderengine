package de.maplesoft.renderengine.exception;

import de.maplesoft.renderengine.geo.shape.Shape;

public class InvalidShapeException extends GeoException {
    public InvalidShapeException(String message) {
        super(message);
    }

    public InvalidShapeException(Class<? extends Shape> caller, int size, int requiredSize) {
        super("Shape of type " +
                caller.toString() +
                " requires exactly " +
                requiredSize +
                " locations, " +
                size +
                " given");
    }
}
