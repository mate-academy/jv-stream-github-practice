package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int FIRST_YEAR = 0;
    private static final int LAST_YEAR = 1;
    private static final int REQUIRED_AGE = 35;
    private static final int TIME_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && candidate.isAllowedToVote()
                && requiredAmountOfYears(candidate.getPeriodsInUkr());
    }

    public boolean requiredAmountOfYears(String periodInUkr) {
        String[] yearToCompare = periodInUkr.split("-");
        return Integer.parseInt(yearToCompare[LAST_YEAR])
                - Integer.parseInt(yearToCompare[FIRST_YEAR]) >= TIME_IN_UKRAINE;
    }
}
