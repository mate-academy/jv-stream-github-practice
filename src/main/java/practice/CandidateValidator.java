package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final String NATIONALITY = "Ukrainian";
    private static final int AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";
    private static final int PERIODS = 2;
    private static final int PER_INDEX_0 = 0;
    private static final int PER_INDEX_1 = 1;

    @Override
    public boolean test(Candidate candidate) {
        if (candidate.getAge() < AGE
                || (!candidate.isAllowedToVote())
                || (!(candidate.getNationality().equals(NATIONALITY)))) {
            return false;
        }

        String[] periods = candidate.getPeriodsInUkr().split(SEPARATOR);
        if (periods.length != PERIODS) {
            return false;
        }
        return (Integer.parseInt(periods[PER_INDEX_1]) - Integer.parseInt(periods[PER_INDEX_0]))
                >= MIN_YEARS_IN_UKRAINE;
    }
}
