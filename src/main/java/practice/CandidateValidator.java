package practice;

import java.util.Optional;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_PRESIDENT_AGE = 35;
    private static final int REQUIRED_YEARS_IN_UKR = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }

        return candidate.getAge() >= MIN_PRESIDENT_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && hasRequiredYearsInUkr(candidate.getPeriodsInUkr());
    }

    private boolean hasRequiredYearsInUkr(String period) {
        return parseYearsInUkr(period)
                .filter(years -> years >= REQUIRED_YEARS_IN_UKR)
                .isPresent();
    }

    private Optional<Integer> parseYearsInUkr(String period) {
        if (period == null) {
            return Optional.empty();
        }

        String[] parts = period.split("-");
        if (parts.length != 2) {
            return Optional.empty();
        }

        try {
            int from = Integer.parseInt(parts[0].trim());
            int to = Integer.parseInt(parts[1].trim());

            if (to < from) {
                return Optional.empty();
            }

            return Optional.of(to - from);

        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}

