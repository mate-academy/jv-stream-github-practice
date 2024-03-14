package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int START_YEAR_INDEX = 0;
    public static final int END_YEAR_INDEX = 1;
    public static final int RESIDENCY_TENURE_THRESHOLD = 10;
    public static final int MINIMUM_ELIGIBLE_AGE = 35;
    public static final String NATIONALITY_UKRAINIAN = "Ukrainian";
    private static final String DATE_RANGE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMUM_ELIGIBLE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKRAINIAN)
                && isResidentForTenYears(candidate);
    }

    private boolean isResidentForTenYears(Candidate candidate) {
        if (candidate.getPeriodsInUkr() != null) {
            String[] years = candidate.getPeriodsInUkr().split(DATE_RANGE_SEPARATOR);
            return (Integer.parseInt(years[END_YEAR_INDEX])
                    - Integer.parseInt(years[START_YEAR_INDEX]))
                    >= RESIDENCY_TENURE_THRESHOLD;
        }
        return false;
    }
}
