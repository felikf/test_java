package com.felix.bloch;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 */
public class ObservableList<E> extends ForwardingList<E> {

    private final List<ListObserver<E>> observers = new ArrayList<>();

    public void addObserver(ListObserver<E> observer) {
        synchronized (observers) {
            observers.add(observer);
        }
    }

    public void removeObserver(ListObserver<E> observer) {
        synchronized (observers) {
            observers.remove(observer);
        }
    }

    private void notifyElementAdded(E element) {
//        synchronized (observers) {
//            for (ListObserver<E> observer : observers) {
//                observer.added(this, element);
//            }
//        }

        List<ListObserver<E>> snapshot;

        synchronized (observers) {
            snapshot = new ArrayList<>(observers);
        }

        for (ListObserver<E> observer : snapshot) {
            observer.added(this, element);
        }

    }

    @Override
    public boolean add(E element) {
        boolean added = super.add(element);

        if (added) {
            notifyElementAdded(element);
        }

        return added;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean result = false;

        for (E e : c) {
            result |= add(e);
        }

        return result;
    }
}
