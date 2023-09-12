package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int VALID_CANDIDATE_AGE = 35;
    private static final int VALID_PERIODS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= VALID_CANDIDATE_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && getCandidatePeriodsInUkr(candidate.getPeriodsInUkr()) >= VALID_PERIODS_IN_UKR;
    }

    private static int getCandidatePeriodsInUkr(String period) {
        String[] periods = period.split("-");
        return Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);
    }
}
