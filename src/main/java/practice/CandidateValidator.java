package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String SEPARATOR_FOR_PERIODS = ",";
    public static final String SEPARATOR_FOR_DATES = "-";
    public static final int ELIGIBLE_AGE = 35;
    public static final String ELIGIBLE_NATIONALITY = "Ukrainian";
    public static final int ELIGIBLE_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().trim().split(SEPARATOR_FOR_PERIODS);
        int totalPeriod = Arrays.stream(periods)
                .mapToInt(period -> {
                    String[] years = period.split(SEPARATOR_FOR_DATES);
                    return Integer.parseInt(years[1].trim())
                            - Integer.parseInt(years[0].trim());
                })
                .sum();

        return candidate.getAge() >= ELIGIBLE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ELIGIBLE_NATIONALITY)
                && totalPeriod >= ELIGIBLE_PERIOD;
    }
}
