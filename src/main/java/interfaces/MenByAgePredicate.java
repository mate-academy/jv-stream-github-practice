package interfaces;

@FunctionalInterface
public interface MenByAgePredicate<P, F, T> {
    boolean validate(P person, F fromAge, T toAge);
}
