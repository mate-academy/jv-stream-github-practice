package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_COUNTRY = 10;

    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split("\\W");
        int start = Integer.parseInt(periodInUkraine[0]);
        int end = Integer.parseInt(periodInUkraine[1]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_REQUIRED_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && end - start >= MIN_YEARS_IN_COUNTRY;
    }
}
