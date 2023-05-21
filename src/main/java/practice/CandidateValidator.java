package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int PERIOD_LIVING_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR_FOR_PERIOD = "-";
    private static final int START_LIVING_IN_UK = 0;
    private static final int END_LIVING_IN_UK = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && getPeriodInUk(candidate) >= PERIOD_LIVING_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    private int getPeriodInUk(Candidate candidate) {
        String[] yearsInUk = candidate.getPeriodsInUkr().split(SEPARATOR_FOR_PERIOD);
        return Integer.parseInt(yearsInUk[END_LIVING_IN_UK])
                - Integer.parseInt(yearsInUk[START_LIVING_IN_UK]);
    }
}
