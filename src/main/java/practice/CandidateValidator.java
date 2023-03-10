package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int FIRST_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;
    private static final int MIN_YEARS_TO_SPEND = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] candidateYearsInCountry = candidate.getPeriodsInUkr().split(SEPARATOR);
        int firstYear = Integer.valueOf(candidateYearsInCountry[FIRST_YEAR_INDEX]);
        int lastYear = Integer.valueOf(candidateYearsInCountry[LAST_YEAR_INDEX]);

        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && (lastYear - firstYear) >= MIN_YEARS_TO_SPEND;
    }
}
