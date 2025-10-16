package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String PERIODS_SEPARATOR = ",";
    private static final String YEAR_SEPARATOR = "-";
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && this.getPeriodInUkr(candidate.getPeriodsInUkr()) >= MIN_PERIOD;
    }

    private int getPeriodInUkr(String period) {
        if (period == null || period.trim().isEmpty()) {
            return 0;
        }

        return Arrays.stream(period.split(PERIODS_SEPARATOR))
                .mapToInt(p -> {
                    String[] values = p.trim().split(YEAR_SEPARATOR);

                    if (values.length != 2) {
                        return 0;
                    }

                    String from = values[FROM_YEAR].trim();
                    String to = values[TO_YEAR].trim();

                    if (from.isEmpty() || to.isEmpty()) {
                        return 0;
                    }

                    return Integer.parseInt(to) - Integer.parseInt(from);
                })
                .sum();
    }
}
