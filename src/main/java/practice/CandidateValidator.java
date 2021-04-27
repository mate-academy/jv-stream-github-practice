package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SPLITTER = "-";
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int VALID_PERIOD = 10;
    private static final int VALID_AGE = 35;
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsRange = candidate.getPeriodsInUkr().split(SPLITTER);
        int periodInUkr = Integer.parseInt(yearsRange[TO_YEAR])
                - Integer.parseInt(yearsRange[FROM_YEAR]);
        return candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && periodInUkr > VALID_PERIOD;
    }
}
