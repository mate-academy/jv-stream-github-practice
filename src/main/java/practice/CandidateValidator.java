package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_EDGE_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX_DASH = "-";
    private static final int MIN_EDGE_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(REGEX_DASH);
        int inUkraineFromYear = Integer.parseInt(periodInUkraine[0]);
        int inUkraineToYear = Integer.parseInt(periodInUkraine[1]);
        int inUkrainePeriod = inUkraineToYear - inUkraineFromYear;
        return candidate.getAge() >= MIN_EDGE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && inUkrainePeriod >= MIN_EDGE_PERIOD_IN_UKR;
    }
}
