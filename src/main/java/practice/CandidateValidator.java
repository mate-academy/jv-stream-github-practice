package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int FROM_YEAR_POSITION = 1;
    private static final int TO_YEAR_POSITION = 0;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(SPLIT_REGEX);
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(yearsInUkraine[FROM_YEAR_POSITION])
                - Integer.parseInt(yearsInUkraine[TO_YEAR_POSITION]) >= MIN_YEARS_IN_UKRAINE;
    }
}
