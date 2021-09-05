package interfaces;

@FunctionalInterface
public interface WorkablePeoplePredicate<A, F, M, P> {
    boolean validate(A fromAge, F femaleToAge, M maleToAge, P person);
}
