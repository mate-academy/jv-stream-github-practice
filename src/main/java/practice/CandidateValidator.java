package practice;

import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int EXPECTED_ARRAY_LENGTH = 2;
    private static final int INDEX_OF_FIRST_ARRAY_ELEMENT = 0;
    private static final int INDEX_OF_SECOND_ARRAY_ELEMENT = 1;
    private static final int EXPECTED_NUMBER_OF_YEARS = 10;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        return Stream.of(
                candidate.getAge() >= MIN_CANDIDATE_AGE,
                candidate.isAllowedToVote(),
                CANDIDATE_NATIONALITY.equals(candidate.getNationality()),
                validatePeriodsInUkraine(candidate.getPeriodsInUkr())
        ).allMatch(Boolean::booleanValue);
    }

    private boolean validatePeriodsInUkraine(String periodsInUkr) {
        if (periodsInUkr == null || periodsInUkr.isEmpty()) {
            return false;
        }

        String[] periods = periodsInUkr.split(SPLIT_SYMBOL);
        if (periods.length != EXPECTED_ARRAY_LENGTH) {
            return false;
        }

        try {
            int startYear = Integer.parseInt(periods[INDEX_OF_FIRST_ARRAY_ELEMENT]);
            int endYear = Integer.parseInt(periods[INDEX_OF_SECOND_ARRAY_ELEMENT]);
            return endYear - startYear >= EXPECTED_NUMBER_OF_YEARS;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
