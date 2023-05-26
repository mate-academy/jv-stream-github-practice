package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int TO_YEAR_INDEX = 1;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEARS_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
            && candidate.isAllowedToVote() == true
            && candidate.getNationality().equals(NATIONALITY)
            && Integer.parseInt(candidate.getPeriodsInUkr().split(YEARS_SEPARATOR)[TO_YEAR_INDEX])
            - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[FROM_YEAR_INDEX])
            >= MIN_PERIOD_IN_UKRAINE;
    }
}
