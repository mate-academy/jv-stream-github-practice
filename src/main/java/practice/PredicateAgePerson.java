package practice;

@FunctionalInterface
public interface PredicateAgePerson<V, T> {
    boolean test(V fromAge, V femaleToAge,
                 V maleToAge, T t);
}
