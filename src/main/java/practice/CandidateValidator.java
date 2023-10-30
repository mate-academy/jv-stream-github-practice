package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int END_YEAR = 1;
    private static final int MINIMAL_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int REQUIRED_YEARS_IN_UKR = 10;
    private static final String YEARS_SEPARATOR = "-";
    private static final int START_YEAR = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(YEARS_SEPARATOR);
        int yearsInUkr = Integer.parseInt(periodInUkr[END_YEAR])
                - Integer.parseInt(periodInUkr[START_YEAR]);
        return yearsInUkr >= REQUIRED_YEARS_IN_UKR
                && candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality());
    }
}
