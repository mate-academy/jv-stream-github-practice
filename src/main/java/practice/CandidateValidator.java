package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATES_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_INDEX_OF_FIRST_YEAR = 0;
    private static final int END_INDEX_OF_FIRST_YEAR = 4;
    private static final int START_INDEX_OF_LAST_YEAR = 5;
    private static final int END_INDEX_OF_LAST_YEAR = 9;
    private static final int MIN_PERIOD_OF_LIVING_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATES_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr().substring(START_INDEX_OF_LAST_YEAR,
                END_INDEX_OF_LAST_YEAR))
                - Integer.parseInt(candidate.getPeriodsInUkr().substring(START_INDEX_OF_FIRST_YEAR,
                END_INDEX_OF_FIRST_YEAR)) >= MIN_PERIOD_OF_LIVING_YEARS;
    }
}
