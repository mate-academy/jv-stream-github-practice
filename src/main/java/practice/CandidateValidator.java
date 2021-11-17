package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_OF_LIVING_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int start = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0, candidate.getPeriodsInUkr().indexOf("-")));
        int end = Integer.parseInt(candidate.getPeriodsInUkr()
                  .substring(candidate.getPeriodsInUkr().indexOf("-") + 1));
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && end - start >= MIN_YEARS_OF_LIVING_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
