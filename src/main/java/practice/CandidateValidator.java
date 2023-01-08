package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] s = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(s[1]) - Integer.parseInt(s[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote() && yearsInUkraine >= 10;
    }
}
