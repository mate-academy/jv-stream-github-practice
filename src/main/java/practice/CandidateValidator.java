package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DASH = "-";
    private static final int beganToLive = 0;
    private static final int finishedLiving = 1;
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearsInUkraine(candidate) >= MIN_YEARS_IN_UKRAINE;
    }

    private int yearsInUkraine(Candidate candidate) {
        String[] data = candidate.getPeriodsInUkr().split(DASH);
        return Integer.parseInt(data[finishedLiving]) - Integer.parseInt(data[beganToLive]);
    }
}
