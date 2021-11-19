package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final static int MIN_AGE_TO_BE_PRESIDENT = 35;
    private final static int MIN_PERIOD_IN_UKRAINE = 10;
    private final static String UKRAINIAN_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int periodInUkraine = Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
        return candidate.getAge() >= MIN_AGE_TO_BE_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && periodInUkraine >= MIN_PERIOD_IN_UKRAINE;
    }
}
