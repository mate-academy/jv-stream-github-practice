package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_THE_CANDIDATE = 35;
    private static final int MIN_YEARS_OF_LIVING_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int index = candidate.getPeriodsInUkr().indexOf("-");
        int start = Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0, index));
        int end = Integer.parseInt(candidate.getPeriodsInUkr()
                  .substring(index + 1));
        return candidate.getAge() >= MIN_AGE_FOR_THE_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY)
                && end - start >= MIN_YEARS_OF_LIVING_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
