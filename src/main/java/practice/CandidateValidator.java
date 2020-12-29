package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_OF_LIVING_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(period[1]) - Integer.parseInt(period[0]);
        return candidate.getAge() >= MIN_AGE
                && periodInUkraine >= MIN_YEARS_OF_LIVING_IN_UKRAINE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
