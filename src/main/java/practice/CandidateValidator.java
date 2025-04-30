package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int VALID_PERIODS_IN_UKRAINIAN = 10;
    private static final String YEARS_SEPARATOR = "-";
    private static final int INDEX_OF_FIRST_RESIDENCE_YEAR = 0;
    private static final int INDEX_OF_LAST_RESIDENCE_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && getLastYearInUkraine(candidate.getPeriodsInUkr())
                - getFirstYearInUkraine(candidate.getPeriodsInUkr()) >= VALID_PERIODS_IN_UKRAINIAN;
    }

    private int getFirstYearInUkraine(String beginningInUkraine) {
        return Integer.parseInt(beginningInUkraine.substring(INDEX_OF_FIRST_RESIDENCE_YEAR,
                beginningInUkraine.indexOf(YEARS_SEPARATOR)));
    }

    private int getLastYearInUkraine(String endingInUkraine) {
        return Integer.parseInt(endingInUkraine.substring(endingInUkraine
                .indexOf(YEARS_SEPARATOR) + INDEX_OF_LAST_RESIDENCE_YEAR));
    }
}
