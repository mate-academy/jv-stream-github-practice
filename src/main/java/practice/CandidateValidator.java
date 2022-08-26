package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int OLDER_THAN = 35;
    private static final int LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLITERATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int period = Integer.parseInt(candidate.getPeriodsInUkr().split(SPLITERATOR)[1])
                - Integer.parseInt(candidate.getPeriodsInUkr().split(SPLITERATOR)[0]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= OLDER_THAN
                && candidate.getNationality().equals(NATIONALITY)
                && period >= LIVE_IN_UKRAINE;
    }
}
