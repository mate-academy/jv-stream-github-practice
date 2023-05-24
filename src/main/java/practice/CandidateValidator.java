package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int LIVING_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_YEAR_INDEX = 0;
    private static final int LAST_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return getPeriodsInUkr(candidate.getPeriodsInUkr()) >= LIVING_IN_UKRAINE
                && candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY);
    }

    private int getPeriodsInUkr(String periodsInUkr) {
        String[] periods = periodsInUkr.split("-");
        return Integer.parseInt(periods[LAST_YEAR_INDEX])
                - Integer.parseInt(periods[START_YEAR_INDEX]);
    }
}
