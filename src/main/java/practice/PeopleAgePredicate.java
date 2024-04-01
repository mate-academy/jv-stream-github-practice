package practice;

@FunctionalInterface
public interface PeopleAgePredicate<V, T> {
    boolean test(V fromAge, V femaleToAge,
                 V maleToAge, T t);
}
