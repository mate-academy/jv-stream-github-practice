package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_ACCEPTABLE_CANDIDATE_AGE = 35;
    private static final int INDEX_OF_SINCE_YEAR_IN_COUNTRY = 0;
    private static final int INDEX_OF_TO_YEAR_IN_COUNTRY = 1;
    private static final String CANDIDATE_ACCEPTABLE_COUNTRY = "Ukrainian";
    private static final int MINIMAL_ACCEPTABLE_YEARS_IN_COUNTRY = 10;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        int yearsFrom = Integer.parseInt(years[INDEX_OF_SINCE_YEAR_IN_COUNTRY]);
        int yearsTo = Integer.parseInt(years[INDEX_OF_TO_YEAR_IN_COUNTRY]);
        return candidate.getAge() >= MINIMAL_ACCEPTABLE_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && CANDIDATE_ACCEPTABLE_COUNTRY.equals(candidate.getNationality())
                && yearsTo - yearsFrom >= MINIMAL_ACCEPTABLE_YEARS_IN_COUNTRY;
    }
}
