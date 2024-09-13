package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_ALLOWED_AGE = 35;
    private static final int MIN_LIVING_TERM = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String PERIOD_DELIMITER = ",";
    private static final String START_STOP_YEAR_DELIMITER = "-";
    private static final int STOP_LIVING = 1;
    private static final int START_LIVING = 0;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_ALLOWED_AGE
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && candidate.isAllowedToVote()
                && getYearsLivedInUkraine(candidate.getPeriodsInUkr()) >= MIN_LIVING_TERM;
    }

    private int getYearsLivedInUkraine(String periodsInUkr) {
        String[] periods = periodsInUkr.split(PERIOD_DELIMITER);
        return Arrays.stream(periods)
                .map(period -> period.split(START_STOP_YEAR_DELIMITER))
                .mapToInt(years -> Integer.parseInt(years[STOP_LIVING])
                        - Integer.parseInt(years[START_LIVING]))
                .sum();
    }
}
