package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String VALID_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int periodInUkraineFrom
                = Integer.parseInt(candidate
                .getPeriodsInUkr()
                        .substring(candidate.getPeriodsInUkr().indexOf("-") + 1));
        int periodInUkraineTo
                = Integer.parseInt(candidate
                .getPeriodsInUkr()
                        .substring(0, candidate.getPeriodsInUkr().indexOf("-")));
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && periodInUkraineFrom
                - periodInUkraineTo
                >= YEARS_IN_UKRAINE;
    }
}
