package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && getPeriodOfResidenceInTheCountry(candidate) >= LIVE_IN_UKRAINE;
    }

    private int getPeriodOfResidenceInTheCountry(Candidate candidate) {
        String[] splitPeriod = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(splitPeriod[1]) - Integer.parseInt(splitPeriod[0]);
    }
}
