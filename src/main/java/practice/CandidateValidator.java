package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int MINIMUM_NUMBER_YEARS = 10;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SEPARATOR);
        if (candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && Integer.parseInt(years[END_YEAR])
                - Integer.parseInt(years[START_YEAR]) >= MINIMUM_NUMBER_YEARS) {
            return true;
        }
        return false;
    }
}

