package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_LIVING_IN_UKRAINE = 10;
    private static final String SPLIT_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SPLIT_REGEX);
        int periodInUkraine = Integer.parseInt(period[1])
                - Integer.parseInt(period[0]);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkraine >= YEARS_LIVING_IN_UKRAINE;
    }
}
