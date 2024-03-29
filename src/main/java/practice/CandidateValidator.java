package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkrain = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && Integer.parseInt(periodInUkrain[1]) - Integer.parseInt(periodInUkrain[0]) >= 10;
    }
}
