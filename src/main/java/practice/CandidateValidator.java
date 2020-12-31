package practice;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_COUNTRY = 10;
    private static final int PERIOD = 2;
    private static final String PATTERN_TIME = "[0-9]{4}";
    private Matcher matcher;

    @Override
    public boolean test(Candidate candidate) {
        return candidate != null && candidate.getAge() >= MIN_AGE
                && NATIONALITY.equals(candidate.getNationality())
                && candidate.isAllowedToVote() && checkPeriod(candidate.getPeriodsInUkr());
    }

    private boolean checkPeriod(String period) {
        if (period == null || isMatch(period)) {
            return false;
        }
        int[] periods = new int[PERIOD];
        matcher = Pattern.compile(PATTERN_TIME).matcher(period);
        for (int i = 0; i < PERIOD; i++) {
            if (matcher.find()) {
                periods[i] = Integer.parseInt(matcher.group());
            }
        }
        return Math.abs(periods[0] - periods[1]) >= YEARS_IN_COUNTRY;
    }

    private boolean isMatch(String period) {
        matcher = Pattern.compile(PATTERN_TIME).matcher(period);
        int timePeriod = 0;
        while (matcher.find()) {
            timePeriod++;
        }
        return timePeriod != PERIOD;
    }
}
