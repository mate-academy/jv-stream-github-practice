package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY_REQUIREMENT = "Ukrainian";
    private static final int REQUIREMENT_LIVE_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY_REQUIREMENT)
                && getPeriodInUkraine(candidate.getPeriodsInUkr()) >= REQUIREMENT_LIVE_PERIOD;
    }

    private int getPeriodInUkraine(String periodInUkraine) {
        String[] years = periodInUkraine.split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }
}
