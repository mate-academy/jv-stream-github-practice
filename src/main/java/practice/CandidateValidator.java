package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && UKRAINIAN_NATIONALITY.equals(candidate.getNationality())
                && calculateYearsSpentInUkraine(
                        candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private int calculateYearsSpentInUkraine(String period) {
        String[] years = period.split("-");
        return Integer.parseInt(years[LAST_YEAR_INDEX]) - Integer.parseInt(years[FIRST_YEAR_INDEX]);
    }
}
