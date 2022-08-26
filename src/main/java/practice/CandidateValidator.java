package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE = 35;
    private static final int LIVING_PERIOD = 10;
    private static final int END_PERIOD = 1;
    private static final int START_PERIOD = 0;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ALLOWED_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && calculatePeriodInUkraine(candidate.getPeriodsInUkr()) >= LIVING_PERIOD;
    }

    private int calculatePeriodInUkraine(String periodInUkraine) {
        String[] years = periodInUkraine.split(REGEX);
        return Integer.parseInt(years[END_PERIOD]) - Integer.parseInt(years[START_PERIOD]);
    }
}

