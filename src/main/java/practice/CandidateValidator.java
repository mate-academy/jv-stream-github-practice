package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DASH = "-";
    private static final int beganToLive = 0;
    private static final int finishedLiving = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearsInUkraine(candidate) >= 10;
    }

    private int yearsInUkraine(Candidate candidate) {
        String[] data = candidate.getPeriodsInUkr().split(DASH);
        return Integer.parseInt(data[finishedLiving]) - Integer.parseInt(data[beganToLive]);
    }
}
