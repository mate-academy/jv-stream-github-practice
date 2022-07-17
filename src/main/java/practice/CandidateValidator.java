package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIODS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriodsInUkraine(candidate.getPeriodsInUkr()) >= PERIODS_IN_UKRAINE;
    }

    private int getPeriodsInUkraine(String periodCandidate) {
        String[] period = periodCandidate.split("-");
        int startPeriod = Integer.parseInt(period[0]);
        int endPeriod = Integer.parseInt(period[1]);
        return endPeriod - startPeriod;
    }
}
