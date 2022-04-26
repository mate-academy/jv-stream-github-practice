package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] fromTo = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(fromTo[1]) - Integer.parseInt(fromTo[0]);
        return candidate.getAge() >= MIN_AGE
                && periodInUkraine >= PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY);
    }
}
