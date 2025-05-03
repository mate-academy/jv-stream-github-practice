package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ELIGIBLE_AGE = 35;
    private static final int INDEX_OF_AGE_FROM = 0;
    private static final int INDEX_OF_AGE_TO = 1;
    private static final int ELIGIBLE_PERIOD = 10;
    private static final String ELIGIBLE_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] temp = candidate.getPeriodsInUkr().split("-");
        return candidate.isAllowedToVote()
                && candidate.getAge() >= ELIGIBLE_AGE
                && Integer.parseInt(temp[INDEX_OF_AGE_TO])
                    - Integer.parseInt(temp[INDEX_OF_AGE_FROM]) >= ELIGIBLE_PERIOD
                && candidate.getNationality().equals(ELIGIBLE_NATIONALITY);
    }
}
