package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String PERIOD_IN_UKR_SPLITTER = "-";
    private static final int MIN_AGE_ALLOWED = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_ALLOWED = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(PERIOD_IN_UKR_SPLITTER);
        int inUkraineFromYear = Integer.parseInt(periodInUkraine[0]);
        int inUkraineToYear = Integer.parseInt(periodInUkraine[1]);
        return candidate.getAge() >= MIN_AGE_ALLOWED
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && inUkraineToYear - inUkraineFromYear >= MIN_PERIOD_ALLOWED;
    }
}
