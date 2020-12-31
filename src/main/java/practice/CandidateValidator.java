package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY_UKR = "Ukrainian";
    private static final int MINIMUM_AGE = 35;
    private static final int PERIOD_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodYears = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(NATIONALITY_UKR)
                && Integer.parseInt(periodYears[1])
                - Integer.parseInt(periodYears[0]) >= PERIOD_YEARS
                && candidate.isAllowedToVote();
    }
}
