package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIODS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getTotalYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_PERIODS_IN_UKRAINE;
    }

    private int getTotalYearsInUkraine(String period) {
        String[] years = period.split("-");
        int yearFrom = Integer.parseInt(years [START_PERIOD_INDEX]);
        int yearTo = Integer.parseInt(years [END_PERIOD_INDEX]);
        return yearTo - yearFrom;
    }
}
