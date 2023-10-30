package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String DASH = "-";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        final int livedFrom = Integer.parseInt(candidate.getPeriodsInUkr().split(DASH)[0]);
        final int livedTo = Integer.parseInt(candidate.getPeriodsInUkr().split(DASH)[1]);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && livedTo - livedFrom >= MIN_YEARS_IN_COUNTRY;
    }
}
