package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int INDEX_LEAVE_FROM = 0;
    private static final int INDEX_LEAVE_TO = 1;
    private static final int MIN_REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_RESIDENCE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_REQUIRED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && isValidByResidenceInUkraine(candidate);
    }

    private boolean isValidByResidenceInUkraine(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split("\\D");
        return Integer.parseInt(yearsInUkraine[INDEX_LEAVE_TO])
                - Integer.parseInt(yearsInUkraine[INDEX_LEAVE_FROM]) >= MIN_RESIDENCE_IN_UKRAINE;
    }
}
