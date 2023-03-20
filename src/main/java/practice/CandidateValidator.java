package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_YEARS = 10;
    private static final int FIRST_DATE = 0;
    private static final int SECOND_DATE = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsSplit = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(yearsSplit[SECOND_DATE])
                - Integer.parseInt(yearsSplit[FIRST_DATE]) >= REQUIRED_YEARS;
    }
}
