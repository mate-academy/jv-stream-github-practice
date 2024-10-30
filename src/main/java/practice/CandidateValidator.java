package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String LINE_SEPARATOR = "-";
    private static final String CORRECT_NATIONALITY = "Ukrainian";
    private static final int ENOUGH_YEARS = 10;
    private static final int MINIMAL_AGE = 35;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= MINIMAL_AGE
                && CORRECT_NATIONALITY.equalsIgnoreCase(candidate.getNationality())
                && candidate.isAllowedToVote()
                && hasSufficientYearsInUkraine(candidate.getPeriodsInUkr());
    }

    private boolean hasSufficientYearsInUkraine(String periodsInUkr) {
        if (periodsInUkr == null || !periodsInUkr.contains(LINE_SEPARATOR)) {
            return false;
        }

        String[] years = periodsInUkr.split(LINE_SEPARATOR);
        int startYear = Integer.parseInt(years[START_YEAR_INDEX].trim());
        int endYear = Integer.parseInt(years[END_YEAR_INDEX].trim());
        int yearsInUkraine = endYear - startYear;
        return yearsInUkraine >= ENOUGH_YEARS;
    }
}
