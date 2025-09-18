package practice;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final Pattern PERIOD_PATTERN = Pattern.compile("(\\d{4})-(\\d{4})");

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null
                || candidate.getAge() < MIN_AGE
                || !candidate.isAllowedToVote()
                || !REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        String periods = candidate.getPeriodsInUkr();
        if (periods == null || periods.isBlank()) {
            return false;
        }

        Matcher matcher = PERIOD_PATTERN.matcher(periods);
        int totalYears = 0;

        while (matcher.find()) {
            try {
                int startYear = Integer.parseInt(matcher.group(1));
                int endYear = Integer.parseInt(matcher.group(2));
                totalYears += (endYear - startYear);
            } catch (NumberFormatException e) {
                return false;
            }
        }

        return totalYears >= MIN_YEARS_IN_UKRAINE;
    }
}
