package interfaces;

@FunctionalInterface
public interface WomenByAgePredicate<P, F> {
    boolean validate(P person, F fromAge);
}
