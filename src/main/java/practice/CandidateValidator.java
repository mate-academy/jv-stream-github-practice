package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int SHOULD_BE_OLDER = 35;
    private static final int LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLITERATOR = "-";

    @Override
    public boolean test(Candidate anotherOne) {
        int period = Integer.parseInt(anotherOne.getPeriodsInUkr().split(SPLITERATOR)[1])
                - Integer.parseInt(anotherOne.getPeriodsInUkr().split(SPLITERATOR)[0]);
        return anotherOne.isAllowedToVote()
                && anotherOne.getAge() >= SHOULD_BE_OLDER
                && anotherOne.getNationality().equals(NATIONALITY)
                && period >= LIVE_IN_UKRAINE;
    }
}
