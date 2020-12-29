package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final String CANDIDATE_COUNTRY = "Ukrainian";
    private static final int CANDIDATE_YEARS_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_COUNTRY)
                && getPeriods(candidate) >= CANDIDATE_YEARS_IN_COUNTRY;
    }

    private int getPeriods(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);
    }
}
