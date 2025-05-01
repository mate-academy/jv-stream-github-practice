package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && checkPeriodInUkr(candidate);
    }

    private boolean checkPeriodInUkr(Candidate candidate) {
        String[] yearsOfString = candidate.getPeriodsInUkr().split("-");
        try {
            return MIN_PERIOD_IN_UKR
                    <= (Integer.parseInt(yearsOfString[END_INDEX])
                    - Integer.parseInt(yearsOfString[START_INDEX]));
        } catch (NumberFormatException e) {
            throw new RuntimeException("Number Format is wrong", e);
        }
    }
}
