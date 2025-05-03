package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_PERIOD = 10;
    private static final int VALID_AGE = 35;
    private static final int ZERO_ELEMENT = 0;
    private static final int ONE_ELEMENT = 1;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(years[ONE_ELEMENT])
                - Integer.parseInt(years[ZERO_ELEMENT]);
        return period >= VALID_PERIOD && candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY);
    }
}
