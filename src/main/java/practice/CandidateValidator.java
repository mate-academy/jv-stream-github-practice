package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVE_AGE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && checkYear(candidate);
    }

    private boolean checkYear(Candidate candidate) {
        String[] ages = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(ages[1])
                - Integer.parseInt(ages[0]) >= MIN_LIVE_AGE;
    }
}
