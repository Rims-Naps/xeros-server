package io.Odyssey.model;

import io.Odyssey.model.entity.Entity;

/**
 * Represents a segment of the map.
 */
public interface Area {

    /**
     * Checks if the {@link Entity} is inside the area.
     * @param entity the entity
     * @return <code>true</code> if the entity is inside the area
     */
    boolean inside(Entity entity);

}
