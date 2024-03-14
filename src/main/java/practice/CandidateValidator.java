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

    private static boolean isResidentForTenYears(Candidate candidate,
                                                 boolean isResidentForTenYears) {
        if (candidate.getPeriodsInUkr() != null) {
            String[] years = candidate.getPeriodsInUkr().split(DATE_RANGE_SEPARATOR);
            isResidentForTenYears = (Integer.parseInt(years[END_YEAR_INDEX])
                    - Integer.parseInt(years[START_YEAR_INDEX]))
                    >= RESIDENCY_TENURE_THRESHOLD;
        }
        return isResidentForTenYears;
    }

    @Override
    public boolean test(Candidate candidate) {
        boolean isResidentForTenYears = false;
        isResidentForTenYears = isResidentForTenYears(candidate, isResidentForTenYears);
        return candidate.getAge() >= MINIMUM_ELIGIBLE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKRAINIAN)
                && isResidentForTenYears;
    }
}
