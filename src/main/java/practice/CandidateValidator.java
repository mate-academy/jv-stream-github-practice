package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String UKRANIAN_NATIONALITY = "Ukrainian";
    private static final String SPLITTER_CHAR = "-";
    private static final int END_OF_LIVING_PERIOD = 1;
    private static final int START_OF_LIVING_PERIOD = 0;

    @Override
    public boolean test(Candidate candidate) {
        String [] yearsLived = candidate.getPeriodsInUkr().split(SPLITTER_CHAR);
        int period = Integer.parseInt(yearsLived[END_OF_LIVING_PERIOD])
                - Integer.parseInt(yearsLived[START_OF_LIVING_PERIOD]);
        return period >= MIN_PERIOD_IN_UKRAINE
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRANIAN_NATIONALITY);
    }
}
