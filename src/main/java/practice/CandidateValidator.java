package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_OF_CANDIDACY = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMUM_YEARS_LIVING = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.isAllowedToVote() && candidate.getAge() >= AGE_OF_CANDIDACY
                && candidate.getNationality().equals(NATIONALITY)) {
            String [] periods = candidate.getPeriodsInUkr().split(REGEX);
            int termOfLiving = Integer.parseInt(periods[YEAR_TO_INDEX])
                    - Integer.parseInt(periods[YEAR_FROM_INDEX]);
            return termOfLiving >= MINIMUM_YEARS_LIVING;
        }
        return false;
    }
}
