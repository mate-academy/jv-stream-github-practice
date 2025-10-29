package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MAX_AGE = 35;
    private static final int PERIOD_PARTS = 2;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY_UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        String[] years = candidate.getPeriodsInUkr().split("-");
        if (years.length != PERIOD_PARTS) {
            return false;
        }

        try {
            int from = Integer.parseInt(years[0].trim());
            int to = Integer.parseInt(years[1].trim());

            return candidate.getAge() >= MAX_AGE
                    && candidate.isAllowedToVote()
                    && NATIONALITY_UKRAINIAN.equalsIgnoreCase(candidate.getNationality())
                    && (to - from) >= MIN_YEARS_IN_UKRAINE;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
