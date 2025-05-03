package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String UKRAINE_NATIONALITY = "Ukrainian";
    private static final String YEARS_SPLIT_SYMBOL = "-";
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final int MIN_LIVING_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] livingYears = candidate.getPeriodsInUkr().split(YEARS_SPLIT_SYMBOL);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINE_NATIONALITY)
                && Integer.parseInt(livingYears[TO_YEAR_INDEX])
                - Integer.parseInt(livingYears[FROM_YEAR_INDEX]) >= MIN_LIVING_YEARS;
    }
}
