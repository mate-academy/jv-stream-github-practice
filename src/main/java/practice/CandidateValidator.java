package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final int MINIMAL_PERIOD = 10;

    public int getPeriod(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MINIMAL_AGE && candidate.getNationality().equals("Ukrainian")
                && getPeriod(candidate) >= MINIMAL_PERIOD && candidate.isAllowedToVote();
    }
}
