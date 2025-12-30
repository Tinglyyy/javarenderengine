package de.maplesoft.renderengine.space.util;

import de.maplesoft.renderengine.space.space2d.Vector2;
import de.maplesoft.renderengine.space.space3d.Vector3;

public class VectorUtils {
    public static Vector3 average(Vector3[] vectors) {
        if(vectors.length == 0)
            return Vector3.zero();

        Vector3 average = Vector3.zero();

        for(Vector3 vector : vectors)
            average.add(vector);


        return average.divide(vectors.length);
    }

    public static Vector2 average(Vector2[] vectors) {
        if(vectors.length == 0)
            return Vector2.zero();

        Vector2 average = Vector2.zero();

        for(Vector2 vector : vectors)
            average.add(vector);

        return average.divide(vectors.length);
    }

}
