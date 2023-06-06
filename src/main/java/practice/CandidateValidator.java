package practice;

import java.time.Year;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN = "Ukrainian";
    private static final String SLASH = "-";
    private static final int YEARS_OLD = 35;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;
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

        String[] years = periodsInUkr.split(SLASH);
        if (years.length > 1) {
            int startYear = Integer.parseInt(years[START_YEAR]);
            int endYear = Integer.parseInt(years[END_YEAR]);
            totalYearsInUkraine = endYear - startYear;
        }

        return totalYearsInUkraine >= MORE_THEN_TEN_YEARS;
    }
}
