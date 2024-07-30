package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int INDEX_START_YEAR = 0;
    private static final int INDEX_END_YEAR = 1;
    private static final int PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && hasLivedInUkraineFor10Years(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineFor10Years(String periodsInUkr) {
        String[] periods = periodsInUkr.split(",");
        int totalYears = 0;

        for (String period : periods) {
            String[] years = period.split("-");
            int startYear = Integer.parseInt(years[INDEX_START_YEAR]);
            int endYear = Integer.parseInt(years[INDEX_END_YEAR]);
            totalYears = endYear - startYear;
        }
        return totalYears >= PERIOD;
    }
}
