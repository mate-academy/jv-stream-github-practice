package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_OF_RESIDENCE = 10;

    public int periodOfResidenceInUkr(String period) {
        int from = Integer.parseInt(period.substring(0, 4));
        int to = Integer.parseInt(period.substring(5, 9));
        return to - from;
    }

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && periodOfResidenceInUkr(candidate.getPeriodsInUkr()) >= PERIOD_OF_RESIDENCE;
    }
}
