package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String PERIODS_DELIMITER = "-";
    private static final int MIN_PERIOD_YEARS = 10;
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getPeriodsInUkr() == null) {
            return false;
        }

        String[] period = candidate.getPeriodsInUkr().trim().split(PERIODS_DELIMITER);

        if (period.length < 2) {
            return false;
        }

        return Integer.parseInt(period[1]) - Integer.parseInt(period[0]) >= MIN_PERIOD_YEARS
                && candidate.getAge() >= MIN_AGE
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && candidate.isAllowedToVote();
    }
}
