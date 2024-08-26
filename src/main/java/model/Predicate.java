package model;

@FunctionalInterface
public interface Predicate<T> {
    boolean test(T t);
}
