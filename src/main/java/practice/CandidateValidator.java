package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final int MINIMUM_AGE = 35;
    private final int MINIMUM_PERIOD_IN_UKR  = 10;
    private final String NATIONALITY_UKR  = "Ukrainian";
    private final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKR )
                && isPeriodValid(candidate);
    }

    private boolean isPeriodValid(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]) >= MINIMUM_PERIOD_IN_UKR;
    }
}
