package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final String NATIONALITY = "Ukrainian";
    private final int MIN_AGE_REQUIRED = 35;
    private final int YEARS_OF_RESIDENCY_REQUIRED = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE_REQUIRED
                && Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr().indexOf("-") + 1))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0,candidate.getPeriodsInUkr().indexOf("-")))
                >= YEARS_OF_RESIDENCY_REQUIRED;
    }
    //write your code here
}
