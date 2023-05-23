package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_LIVING_YEAR = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && livingYear(candidate) > MIN_LIVING_YEAR;
    }

    private int livingYear(Candidate candidate) {
        return Integer.parseInt(candidate.getPeriodsInUkr()
                        .substring(candidate.getPeriodsInUkr().indexOf('-') + 1))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                        .substring(0, candidate.getPeriodsInUkr().indexOf('-')));
    }
}
