package practice;

import java.util.function.Predicate;
import model.Candidate;
import model.Nationality;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INCLUDE_START_AND_END_YEAR = 1;
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;
    private static final int MIN_AGE_OF_CANDIDATES = 35;
    private static final int MIN_YEARS_OF_RESIDENCE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return isEligible(candidate);
    }

    private boolean isEligible(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE_OF_CANDIDATES
                && candidate.getNationality() == Nationality.UKR.getValue()
                && calculateYearsOfResidence(candidate.getPeriodsInUkr()) >= MIN_YEARS_OF_RESIDENCE;
    }

    private int calculateYearsOfResidence(String period) {
        String[] periods = period.split("-");
        int fromYear = Integer.parseInt(periods[FROM_YEAR]);
        int toYear = Integer.parseInt(periods[TO_YEAR]);
        return toYear - fromYear + INCLUDE_START_AND_END_YEAR;
    }
}
