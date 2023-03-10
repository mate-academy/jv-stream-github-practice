package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DELIMITER = "-";
    private static final int MIN_PERIODS_IN_UKRAINE = 10;
    private static final int MINIMAL_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MAP_KEY_INDEX = 0;
    private static final int MAP_VALUE_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(DELIMITER);
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(yearsInUkraine[MAP_VALUE_INDEX])
                - Integer.parseInt(yearsInUkraine[MAP_KEY_INDEX]))
                >= MIN_PERIODS_IN_UKRAINE && candidate.isAllowedToVote();
    }
}
