package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int SECOND_YEAR_INDEX = 1;
    private static final int VALID_CANDIDATE_AGE = 35;
    private static final int REQUIRED_RESIDENCE_TIME = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] splitPeriods = candidate.getPeriodsInUkr().split("-");
        int yearsOfResidenceInUkraine
                = Integer.parseInt(splitPeriods[SECOND_YEAR_INDEX])
                - Integer.parseInt(splitPeriods[FIRST_YEAR_INDEX]);

        return candidate.getAge() >= VALID_CANDIDATE_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearsOfResidenceInUkraine >= REQUIRED_RESIDENCE_TIME;
    }
}
