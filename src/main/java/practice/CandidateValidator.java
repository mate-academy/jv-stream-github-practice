package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIODS_IN_UKR = 10;
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsOfResidence = candidate.getPeriodsInUkr().split("-");
        int periodsOfResidence = Integer.parseInt(yearsOfResidence[END_PERIOD_INDEX])
                - Integer.parseInt(yearsOfResidence[START_PERIOD_INDEX]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodsOfResidence >= MIN_PERIODS_IN_UKR;
    }
}

