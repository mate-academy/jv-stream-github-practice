package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_AGE = 35;
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int VALID_PERIODS_IN_UKRAINIAN = 10;
    private static final String YEARS_SEPARATOR = "-";
    private static final int INDEX_OF_FIRST_RESIDENCE_YEAR = 0;
    private static final int INDEX_OF_LAST_RESIDENCE_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(candidate.getPeriodsInUkr()
                        .indexOf(YEARS_SEPARATOR) + INDEX_OF_LAST_RESIDENCE_YEAR))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(INDEX_OF_FIRST_RESIDENCE_YEAR, candidate.getPeriodsInUkr()
                        .indexOf(YEARS_SEPARATOR))) >= VALID_PERIODS_IN_UKRAINIAN) {
            return true;
        }
        return false;
    }
}
