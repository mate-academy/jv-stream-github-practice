package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_MINIMUM_AGE = 35;
    private static final int REQUIRED_PERIOD_IN_COUNTRY = 10;
    private static final int BEGINNING = 0;
    private static final int END = 1;

    @Override
    public boolean test(Candidate candidate) {
        int beginningOfPeriodInUkr = Integer.parseInt(
                candidate.getPeriodsInUkr().split("-")[BEGINNING]);
        int endOfPeriodInUkr = Integer.parseInt(
                candidate.getPeriodsInUkr().split("-")[END]);
        return candidate.getAge() >= REQUIRED_MINIMUM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && endOfPeriodInUkr - beginningOfPeriodInUkr >= REQUIRED_PERIOD_IN_COUNTRY;
    }
}
