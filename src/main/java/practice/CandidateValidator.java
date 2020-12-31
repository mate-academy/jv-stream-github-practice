package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_COUNTRY = 10;

    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_REQUIRED_AGE
                && getPeriodOfLivingInUA(candidate) >= MIN_YEARS_IN_COUNTRY;
    }

    private int getPeriodOfLivingInUA(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[0]);
    }
}
