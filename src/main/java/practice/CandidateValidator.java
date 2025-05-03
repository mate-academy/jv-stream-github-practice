package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final int VALID_YEAR_PERIOD = 10;
    private static final int INDEX_START = 0;
    private static final int INDEX_END = 1;
    private static final String VALID_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        int start = Integer.parseInt(years[INDEX_START]);
        int end = Integer.parseInt(years[INDEX_END]);
        return candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(VALID_NATIONALITY)
                && (end - start) > VALID_YEAR_PERIOD;
    }

}
