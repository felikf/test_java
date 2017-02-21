package com.felix.bloch;

/**
 */
public interface ListObserver<E> {
    void added(ObservableList<E> list, E element);
}
