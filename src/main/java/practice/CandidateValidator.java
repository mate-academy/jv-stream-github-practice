package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_PRESIDENT = 35;
    private static final int MIN_LIVING_IN_UKRAINE = 10;
    private static final String SUITABLE_NATIONALITY = "Ukrainian";
    private static final String PERIOD_DELIMITER = "-";
    private static final int INDEX_OF_START_YEAR = 0;
    private static final int INDEX_OF_END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(SUITABLE_NATIONALITY)
                && candidate.getAge() >= MIN_AGE_FOR_PRESIDENT
                && candidate.isAllowedToVote()
                && getYearsLivingInUkraine(candidate)
                >= MIN_LIVING_IN_UKRAINE;
    }

    private int getYearsLivingInUkraine(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr()
                .split(PERIOD_DELIMITER)[INDEX_OF_END_YEAR])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split(PERIOD_DELIMITER)[INDEX_OF_START_YEAR]);
    }
}
