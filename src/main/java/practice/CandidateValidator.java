package practice;

import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKR = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final Pattern PERIOD_PATTERN = Pattern.compile("(\\d{4})-(\\d{4})");

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        if (candidate.getAge() < MIN_AGE) {
            return false;
        }

        if (!candidate.isAllowedToVote()) {
            return false;
        }

        if (!REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        String periods = candidate.getPeriodsInUkr();
        if (periods == null || periods.isEmpty()) {
            return false;
        }

        int totalYears = 0;
        Matcher matcher = PERIOD_PATTERN.matcher(periods);
        while (matcher.find()) {
            try {
                int start = Integer.parseInt(matcher.group(1));
                int end = Integer.parseInt(matcher.group(2));
                if (end > start) {
                    totalYears += (end - start);
                }
            } catch (NumberFormatException e) {
                // Невірний фрагмент періоду — пропускаємо його
                continue;
            }
        }

        return totalYears >= REQUIRED_YEARS_IN_UKR;
    }
}
