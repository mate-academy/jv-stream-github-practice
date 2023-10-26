package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR_SYMBOL = "-";
    private static final int MINIMUM_AGE_VALUE = 35;
    private static final int MINIMUM_YEARS_IN_UKRAINE_VALUE = 10;
    private static final int FIRST_ELEMENT_INDEX = 0;
    private static final int LAST_ELEMENT_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE_VALUE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getYearsInUkraine(candidate) >= MINIMUM_YEARS_IN_UKRAINE_VALUE;
    }

    private int getYearsInUkraine(Candidate candidate) {
        List<Integer> years = Arrays.stream(candidate.getPeriodsInUkr().split(SEPARATOR_SYMBOL))
                .map(Integer::parseInt).toList();
        return years.get(LAST_ELEMENT_INDEX) - years.get(FIRST_ELEMENT_INDEX);
    }
}
