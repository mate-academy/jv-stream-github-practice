package practice;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final Pattern PERIOD_PATTERN = Pattern.compile("\\d{4}-\\d{4}");

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < 35 || !candidate.isAllowedToVote()
                || !"Ukrainian".equals(candidate.getNationality())) {
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
            return startYear < endYear && (endYear - startYear) >= 10;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
