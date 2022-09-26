package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int POSITION_YEAR_WHEN_ARRIVAL_TO_UKRAINE = 0;
    private static final int POSITION_ACTUAL_YEAR = 1;
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_YEARS_WHICH_CANDIDATE_MUST_STAND_IN_COUNTRY = 10;
    private static final String UKRAINIAN = "Ukrainian";
    private static final String DELIMITER = "-";
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN)
                && getYearsInUkraine(candidate.getPeriodsInUkr())
                > MIN_YEARS_WHICH_CANDIDATE_MUST_STAND_IN_COUNTRY;
    }

    private int getYearsInUkraine(String period) {
        String[] yearsInUkraine = period.split(DELIMITER);
        return Integer.parseInt(yearsInUkraine[POSITION_ACTUAL_YEAR]) -
                Integer.parseInt(yearsInUkraine[POSITION_YEAR_WHEN_ARRIVAL_TO_UKRAINE]);
    }
}
