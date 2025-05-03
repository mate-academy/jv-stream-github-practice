package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_CANDIDATE_AGE = 35;
    private static final String ALLOWED_CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int PERIOD_IN_COUNTRY = 10;
    private static final String YEARS_DELIMITER = "-";
    private static final int YEAR_FROM_INDEX = 0;
    private static final int YEAR_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null) {
            return false;
        }
        final String[] yearsOfLivingInCountry = candidate.getPeriodsInUkr().split(YEARS_DELIMITER);
        final int yearFrom = Integer.parseInt(yearsOfLivingInCountry[YEAR_FROM_INDEX]);
        final int yearTo = Integer.parseInt(yearsOfLivingInCountry[YEAR_TO_INDEX]);
        return candidate.getAge() >= ALLOWED_CANDIDATE_AGE
                && ALLOWED_CANDIDATE_NATIONALITY.equals(candidate.getNationality())
                && candidate.isAllowedToVote()
                && yearTo - yearFrom >= PERIOD_IN_COUNTRY;
    }
}
