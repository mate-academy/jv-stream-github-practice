package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_SPENT_IN_UKR = 10;
    private static final int FROM_YEAR_POSITION = 1;
    private static final int TO_YEAR_POSITION = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] timeSpentInUkr = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE
                &&
                candidate.isAllowedToVote()
                &&
                candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(timeSpentInUkr[FROM_YEAR_POSITION])
                - Integer.parseInt(timeSpentInUkr[TO_YEAR_POSITION]) >= MIN_YEARS_SPENT_IN_UKR;
    }
}
