package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_LIVING_PERIOD = 10;
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_DATA_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && calculatePeriodInUkr(candidate.getPeriodsInUkr()) >= MIN_LIVING_PERIOD;
    }

    private int calculatePeriodInUkr(String periodData) {
        String[] years = periodData.split(PERIOD_DATA_REGEX);
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return endYear - startYear;
    }
}
