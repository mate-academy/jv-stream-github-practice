package practice;

@FunctionalInterface
public interface WomanWithCatPredicate<T, V> {
    boolean test(T t, V femaleAge);
}
