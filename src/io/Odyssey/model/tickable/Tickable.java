package io.Odyssey.model.tickable;

public interface Tickable<T> {

    void tick(TickableContainer<T> container, T t);

}
