package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_COUNTRY = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
     public boolean test(Candidate candidate) {
        String[] periodInUkraineStrings = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine = Integer.parseInt(periodInUkraineStrings[1])
                - Integer.parseInt(periodInUkraineStrings[0]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkraine >= MIN_PERIOD_IN_COUNTRY;
    }
}
