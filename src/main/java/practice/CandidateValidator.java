package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        boolean checkPeriodInUkr;
        String[] yearsOfString = candidate.getPeriodsInUkr().split("-");
        try {
            int yearsStart = Integer.parseInt(yearsOfString[0]);
            int yearsEnd = Integer.parseInt(yearsOfString[1]);
            checkPeriodInUkr = MIN_PERIOD_IN_UKR <= (yearsEnd - yearsStart);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Number Format is wrong", e);
        }
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && checkPeriodInUkr;
    }
}
