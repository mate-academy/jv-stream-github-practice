package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;
    private static final int REQUIRED_YEARS = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] splitYears = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && Integer.parseInt(splitYears[END_YEAR])
                - Integer.parseInt(splitYears[START_YEAR]) >= REQUIRED_YEARS;
    }
}
