package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String YEAR_SPLITTER = "-";
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final int FIRST_YEAR_IN_UKR = 0;
    private static final int LAST_YEAR_IN_UKR = 1;
    private static final int MINIMUM_AGE = 35;
    private static final int MINIMUM_YEAR_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] year = candidate.getPeriodsInUkr().split(YEAR_SPLITTER);
        int yearInUkr = Integer.parseInt(year[LAST_YEAR_IN_UKR])
                                            - Integer.parseInt(year[FIRST_YEAR_IN_UKR]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && yearInUkr >= MINIMUM_YEAR_IN_UKR;
    }
}
