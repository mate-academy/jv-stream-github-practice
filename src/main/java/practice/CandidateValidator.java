package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD_IN_UKRAINE = 10;
    private static final int CANDIDATE_OLD_TO = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String PERIOD_SEPARATOR = "-";
    private static final int START_PERIOD_INDEX = 0;
    private static final int END_PERIOD_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(PERIOD_SEPARATOR);

        try {
            int period = Integer.parseInt(periods[END_PERIOD_INDEX])
                    - Integer.parseInt(periods[START_PERIOD_INDEX]);

            if (period < PERIOD_IN_UKRAINE || candidate.getAge() < CANDIDATE_OLD_TO
                    || !candidate.getNationality().equals(NATIONALITY)
                    || !candidate.isAllowedToVote()) {
                return false;
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid period format: unable to parse year",e);
        }
        return true;
    }

}
