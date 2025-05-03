package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int YEARS_OLD = 35;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final int MORE_THEN_TEN_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String name = candidate.getName();
        int age = candidate.getAge();
        boolean allowedToVote = candidate.isAllowedToVote();
        String nationality = candidate.getNationality();
        String periodsInUkr = candidate.getPeriodsInUkr();

        return age >= YEARS_OLD && allowedToVote
                && nationality.equals(UKRAINIAN)
                && hasLivedInUkraineFor10Years(periodsInUkr)
                && candidate.getName().equals(name);
    }

    private boolean hasLivedInUkraineFor10Years(String periodsInUkr) {
        int totalYearsInUkraine = 0;

        String[] years = periodsInUkr.split(SEPARATOR);
        if (years.length > 1) {
            int startYear = Integer.parseInt(years[FROM_YEAR_INDEX]);
            int endYear = Integer.parseInt(years[TO_YEAR_INDEX]);
            totalYearsInUkraine = endYear - startYear;
        }

        return totalYearsInUkraine >= MORE_THEN_TEN_YEARS;
    }
}
