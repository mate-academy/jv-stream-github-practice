package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_PERIOD = 10;
    private static final int VALID_AGE = 35;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return period >= VALID_PERIOD && candidate.isAllowedToVote()
                && candidate.getAge() >= VALID_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY);
    }
}
