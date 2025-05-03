package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERMISSIBLE_AGE_FOR_CANDIDATES = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String EXPECTED_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR_BETWEEN_YEARS = "-";
    private static final int INDEX_OF_FIRST_ELEMENT = 0;
    private static final int INDEX_OF_SECOND_ELEMENT = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(SEPARATOR_BETWEEN_YEARS);
        int yearOfArrival = Integer.parseInt(periods[INDEX_OF_FIRST_ELEMENT]);
        int currentYear = Integer.parseInt(periods[INDEX_OF_SECOND_ELEMENT]);
        return candidate.getAge() >= PERMISSIBLE_AGE_FOR_CANDIDATES
                && candidate.getNationality().equals(EXPECTED_NATIONALITY)
                && currentYear - yearOfArrival >= MIN_PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
