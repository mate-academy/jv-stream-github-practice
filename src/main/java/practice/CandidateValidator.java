package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SPLITTER = "-";
    private static final int MAX_AGE = 35;
    private static final int FROM_YEAR_INDEX = 0;
    private static final int TO_YEAR_INDEX = 1;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(SPLITTER);
        return candidate.getAge() >= MAX_AGE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(periodInUkraine[TO_YEAR_INDEX])
                - Integer.parseInt(periodInUkraine[FROM_YEAR_INDEX])) >= MIN_YEARS_IN_UKRAINE;
    }
}
