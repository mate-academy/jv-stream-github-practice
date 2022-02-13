package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String PERIOD_SPLIT_REGEX = "-";
    public static final String REQUIRED_NATIONALITY = "Ukrainian";
    public static final int FIRST_PART_INDEX = 0;
    public static final int LAST_PART_INDEX = 1;
    public static final int MIN_PERIOD_IN_UKR = 10;
    public static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && checkPeriods(candidate);
    }

    private boolean checkPeriods(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(PERIOD_SPLIT_REGEX);
        int firstPeriod = Integer.parseInt(years[FIRST_PART_INDEX]);
        int lastPeriod = Integer.parseInt(years[LAST_PART_INDEX]);
        return lastPeriod - firstPeriod >= MIN_PERIOD_IN_UKR;
    }
}
