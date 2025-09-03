package core.basesyntax;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_COUNTRY = 10;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && checkTimeLivingInCountry(candidate);
    }

    private boolean checkTimeLivingInCountry(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split(SEPARATOR);
        if (period.length != 2) {
            return false;
        }
        try {
            int start = Integer.parseInt(period[0]);
            int end = Integer.parseInt(period[1]);
            return (end - start) >= MIN_YEARS_IN_COUNTRY;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
