package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEAR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsinUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && Integer.parseInt(periodsinUkraine[1]) - Integer.parseInt(periodsinUkraine[0])
                >= MIN_YEAR;
    }
}
