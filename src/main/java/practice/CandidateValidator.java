package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEARS_IN_COUNTRY = 10;
    private static final int BEGIN_PERIOD = 0;
    private static final int END_PERIOD = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[END_PERIOD])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[BEGIN_PERIOD])
                > YEARS_IN_COUNTRY;
    }
}
