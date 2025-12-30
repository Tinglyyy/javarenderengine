package de.maplesoft.renderengine.space.raycast;

import de.maplesoft.renderengine.renderobject.RenderObject;
import de.maplesoft.renderengine.renderobject.gameobject.GameObject;
import de.maplesoft.renderengine.space.grid.Grid3D;
import de.maplesoft.renderengine.space.space3d.Vector3;

import java.util.Set;

public class RayCast {
    public static RaycastResult rayCast(Grid3D grid3D, Vector3 origin, Vector3 endPoint) {
        return rayCast(grid3D, origin, endPoint.normalize(), origin.clone().subtract(origin).getMagnitude());
    }

    public static RaycastResult rayCast(Grid3D grid3D, Vector3 origin, Vector3 direction, double range) {
        Vector3 v = direction.multiply(RenderObject.RAYCAST_STEP);

        RaycastResult raycastResult = RaycastResult.emptyResult();

        while(true) {
            origin.add(v);

            double mag = origin.getMagnitude();

            if(mag >= range)
                break;

            Set<GameObject> found = grid3D.getObjects(origin);

            if(!found.isEmpty()) {
                raycastResult.getGameObjects().addAll(found);
                raycastResult.setDistance(mag);
            }
        }

        return raycastResult;
    }

    public static RaycastResult rayCastOne(Grid3D grid3D, Vector3 origin, Vector3 endPoint) {
        return rayCastOne(grid3D, origin, endPoint.normalize(), origin.clone().subtract(origin).getMagnitude());
    }

    public static RaycastResult rayCastOne(Grid3D grid3D, Vector3 origin, Vector3 direction, double range) {
        Vector3 v = direction.multiply(RenderObject.RAYCAST_STEP);

        while(true) {
            origin.add(v);

            double mag = origin.getMagnitude();

            if(mag >= range)
                break;

            Set<GameObject> found = grid3D.getObjects(origin);

            if(!found.isEmpty())
                return new RaycastResult(found, mag);
        }

        return RaycastResult.emptyResult();
    }
}
