package com.felix.test;

import java.util.function.Predicate;

@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);

}
