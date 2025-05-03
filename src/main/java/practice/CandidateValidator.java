package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";
    private static final int ELIGIBLE_AGE = 35;
    private static final int ELIGIBLE_PERIOD = 10;
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] splitYearValues = candidate.getPeriodsInUkr().split("-");
        return ELIGIBLE_NATIONALITY.equals(candidate.getNationality())
                && candidate.getAge() >= ELIGIBLE_AGE
                && candidate.isAllowedToVote()
                && Integer.parseInt(splitYearValues[YEAR_TO_INDEX])
                - Integer.parseInt(splitYearValues[YEAR_FROM_INDEX]) >= ELIGIBLE_PERIOD;
    }
}
