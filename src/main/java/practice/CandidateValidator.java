package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int INDEX_OF_START_YEAR = 0;
    private static final int INDEX_OF_END_YEAR = 1;
    private static final String RIGHT_NATIONALITY = "Ukrainian";
    private static final String PERIOD_DELIMITER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(RIGHT_NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && getYearsLivingInUkraine(candidate)
                >= MIN_YEARS_IN_UKRAINE;
    }

    private int getYearsLivingInUkraine(Candidate candidate) {
        String[] splitted = candidate.getPeriodsInUkr().split(PERIOD_DELIMITER);
        return Integer.parseInt(splitted[INDEX_OF_END_YEAR])
                - Integer.parseInt(splitted[INDEX_OF_START_YEAR]);
    }
}
