package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String DATA_SEPARATOR = "-";
    private static final int MINIMUM_PERIOD = 10;
    private static final String PERIOD_MATCHER_REGEX = "\\d\\d\\d\\d-\\d\\d\\d\\d";

    @Override
    public boolean test(Candidate candidate) {
        preValidate(candidate);
        String[] citizenYears = candidate.getPeriodsInUkr().split(DATA_SEPARATOR);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && (Integer.parseInt(citizenYears[1])
                - Integer.parseInt(citizenYears[0])) >= MINIMUM_PERIOD;
    }

    private void preValidate(Candidate candidate) {
        if (candidate == null
                || candidate.getNationality() == null
                || candidate.getPeriodsInUkr() == null
                || !candidate.getPeriodsInUkr().matches(PERIOD_MATCHER_REGEX)) {
            throw new RuntimeException("Invalid candidate data occurred for: " + candidate);
        }
    }
}
