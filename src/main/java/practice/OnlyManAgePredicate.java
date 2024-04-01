package practice;

@FunctionalInterface
public interface OnlyManAgePredicate<T, V> {
    boolean test(T person, V fromAge, V toAge);
}
