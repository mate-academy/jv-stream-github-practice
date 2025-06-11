package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int VALID_PERIOD_LENGTH = 2;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;

    private static final String PERIOD_SEPARATOR = ",";
    private static final String YEAR_RANGE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && UKRAINIAN_NATIONALITY.equals(candidate.getNationality())
                && livedInUkraineLongEnough(candidate.getPeriodsInUkr());
    }

    public boolean livedInUkraineLongEnough(String periodsInUkr) {
        if (periodsInUkr == null || periodsInUkr.isEmpty()) {
            return false;
        }

        inint totalYearsInUkraine = Arrays.stream(periodsInUkr.split(PERIOD_SEPARATOR))
                .map(String::trim)
                .map(period -> period.split(YEAR_RANGE_SEPARATOR))
                .filter(years -> years.length == VALID_PERIOD_LENGTH)
                .mapToInt(years -> Integer.parseInt(years[END_YEAR_INDEX].trim())
                        - Integer.parseInt(years[START_YEAR_INDEX].trim()) + 1)
                .sum();
    }
}
