package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int VALID_AGE_FOR_CANDIDATE = 35;
    public static final int REQUIRED_PERIOD_FOR_RESIDENCE_IN_UKRAINE = 10;
    public static final String REQUIRED_NATIONALITY = "Ukrainian";
    public static final String DASH = "-";
    public static final int FROM_YEAR_INDEX = 0;
    public static final int TO_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null && candidate.getAge() >= VALID_AGE_FOR_CANDIDATE
              && candidate.getNationality().equals(REQUIRED_NATIONALITY)
              && candidate.isAllowedToVote()
              && (Integer.parseInt(candidate.getPeriodsInUkr().split(DASH)[TO_YEAR_INDEX])
                - Integer.parseInt(candidate.getPeriodsInUkr().split(DASH)[FROM_YEAR_INDEX]))
              >= REQUIRED_PERIOD_FOR_RESIDENCE_IN_UKRAINE;
    }
}
