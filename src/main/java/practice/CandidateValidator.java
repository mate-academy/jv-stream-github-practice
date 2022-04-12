package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_PERIOD = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final boolean REQUIRED_VOTE = true;

    @Override
    public boolean test(Candidate candidate) {
        String[] fromTo = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(fromTo[1]) - Integer.parseInt(fromTo[0]);

        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote() == REQUIRED_VOTE
                && period >= REQUIRED_PERIOD;
    }
}
