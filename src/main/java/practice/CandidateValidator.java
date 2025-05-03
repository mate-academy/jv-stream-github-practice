package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int INDEX_YEAR_FROM = 0;
    private static final int INDEX_YEAR_TILL = 1;

    @Override
    public boolean test(Candidate candidate) {
        return (candidate.getAge() >= MIN_AGE && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && getPeriodInUkraine(candidate) > MIN_PERIOD_IN_UKRAINE);
    }

    private int getPeriodInUkraine(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[INDEX_YEAR_TILL]) - Integer.parseInt(years[INDEX_YEAR_FROM]);
    }
}
