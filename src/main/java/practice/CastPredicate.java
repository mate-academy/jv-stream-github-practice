package practice;

import model.Person;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class CastPredicate implements Predicate <Person> {
    @Override
    public boolean test(Person person) {
        return true;
    }
}


