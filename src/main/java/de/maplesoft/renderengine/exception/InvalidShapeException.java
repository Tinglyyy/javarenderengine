package de.maplesoft.renderengine.exception;

import de.maplesoft.renderengine.rendergeo.shape.RenderShape;

public class InvalidShapeException extends GeoException {
    public InvalidShapeException(String message) {
        super(message);
    }

    public InvalidShapeException(Class<? extends RenderShape> caller, int size, int requiredSize) {
        super(STR."Shape of type \{caller.toString()} requires exactly \{requiredSize} locations, \{size} given");
    }
}
