package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN = "Ukrainian";
    private static final String PERIOD_DELIMITER = ",";
    private static final String YEAR_DELIMITER = "-";
    private static final String PRESENT = "present";
    private static final int MAX_AGE = 35;
    private static final int YEARS_LENGTH = 2;
    private static final int INDEX_START = 0;
    private static final int INDEX_END = 1;
    private static final int MAX_YEARS = 10;

    @Override
  public boolean test(Candidate candidate) {
        return candidate.getAge() >= MAX_AGE
            && candidate.isAllowedToVote()
            && UKRAINIAN.equalsIgnoreCase(candidate.getNationality())
            && livedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineForTenYears(String periodsInUkr) {
        int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        int totalYears = Arrays.stream(periodsInUkr.split(PERIOD_DELIMITER))
                .map(period -> period.split(YEAR_DELIMITER))
                .filter(years -> years.length == YEARS_LENGTH)
                .mapToInt(years -> {
                    int startYear = Integer.parseInt(years[INDEX_START]);
                    int endYear = years[INDEX_END].equalsIgnoreCase(PRESENT)
                            ? currentYear : Integer.parseInt(years[INDEX_END]);
                    return endYear - startYear;
                })
                .sum();
        return totalYears >= MAX_YEARS;
    }
}
