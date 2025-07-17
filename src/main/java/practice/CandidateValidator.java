package practice;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final Pattern PERIOD_PATTERN = Pattern.compile("\\d{4}-\\d{4}");
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < MIN_AGE || !candidate.isAllowedToVote()
                || !REQUIRED_NATIONALITY.equals(candidate.getNationality())) {
            return false;
        }

        String periodsInUkr = candidate.getPeriodsInUkr();
        if (!PERIOD_PATTERN.matcher(periodsInUkr).matches()) {
            return false;
        }

        String[] periods = periodsInUkr.split("-");
        try {
            int startYear = Integer.parseInt(periods[0].trim());
            int endYear = Integer.parseInt(periods[1].trim());
            return startYear < endYear && (endYear - startYear) >= MIN_YEARS_IN_UKRAINE;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
