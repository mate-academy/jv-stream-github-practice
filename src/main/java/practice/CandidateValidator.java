package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final int ALLOWED_MIN_YEARS = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int startPeriod = Integer.parseInt(years[0]);
        int endPeriod = Integer.parseInt(years[1]);
        return candidate.getAge() >= ALLOWED_MIN_YEARS && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && endPeriod - startPeriod >= 10;
    }
}
