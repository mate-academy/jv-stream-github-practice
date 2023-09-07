package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIOD_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return candidate.getAge() >= REQUIRED_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkr >= REQUIRED_PERIOD_IN_UKR;
    }
}
