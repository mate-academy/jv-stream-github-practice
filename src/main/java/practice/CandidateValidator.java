package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_DATE_INDEX = 0;
    private static final int TO_DATE_INDEX = 1;
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && livesInUkraineForTenYears(candidate)
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY);
    }

    private boolean livesInUkraineForTenYears(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periods[TO_DATE_INDEX])
                - Integer.parseInt(periods[FROM_DATE_INDEX]) >= 10;
    }
}
