package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_REQ = 35;
    private static final int MIN_YEAR_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] period = candidate.getPeriodsInUkr().split("[\\W]");
        int periodBy = Integer.parseInt(period[0]);
        int periodFor = Integer.parseInt(period[1]);
        return candidate.getAge() >= MIN_AGE_REQ
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodFor - periodBy >= MIN_YEAR_IN_UKRAINE;
    }
}
