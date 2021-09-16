package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int OLDER_THAN = 35;
    private static final int LIVE_IN_UKRAINE = 10;
    private static final String UKRAINE_CITIZEN = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int START_INDEX = 0;

    @Override
    public boolean test(Candidate e) {
        return e.getAge() >= OLDER_THAN
                && Integer.parseInt(e.getPeriodsInUkr()
                        .substring(e.getPeriodsInUkr().indexOf(SEPARATOR) + 1))
                - Integer.parseInt(e.getPeriodsInUkr()
                        .substring(START_INDEX,e.getPeriodsInUkr().indexOf(SEPARATOR)))
                > LIVE_IN_UKRAINE
                && e.isAllowedToVote()
                && e.getNationality().equals(UKRAINE_CITIZEN);
    }
}
