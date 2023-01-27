package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;
    private static final String MANDATORY_NATIONALITY = "Ukrainian";
    private static final String PERIOD_SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(PERIOD_SPLITTER);
        int period = Integer.parseInt(years[END_PERIOD_INDEX])
                - Integer.parseInt(years[START_PERIOD_INDEX]);

        return candidate.getAge() >= MIN_AGE
              && candidate.isAllowedToVote()
              && MANDATORY_NATIONALITY.equals(candidate.getNationality())
              && period >= MIN_PERIOD_IN_UKRAINE;
    }
}
