package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_CANDIDATE_AGE = 35;
    private static final int MINIMAL_PERIOD_IN_UKRAINE = 10;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";

    private int getPeriod(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_CANDIDATE_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && getPeriod(candidate) >= MINIMAL_PERIOD_IN_UKRAINE && candidate.isAllowedToVote();
    }
}
