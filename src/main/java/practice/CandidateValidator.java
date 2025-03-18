package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int PERIODS_IN_UKR = 10;
    private static final String NATIONALITY_UKRAINIAN = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(NATIONALITY_UKRAINIAN)
                && candidate.isAllowedToVote()
                && (endYear - startYear) >= PERIODS_IN_UKR;
    }
}
