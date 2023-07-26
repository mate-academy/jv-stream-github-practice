package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String DASH = "-";
    private static final int BEGAN_TO_LIVE_INDEX = 0;
    private static final int FINISHED_LIVING_INDEX = 1;
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearsInUkraine(candidate) >= MIN_YEARS_IN_UKRAINE;
    }

    private int yearsInUkraine(Candidate candidate) {
        String[] data = candidate.getPeriodsInUkr().split(DASH);
        return Integer.parseInt(data[FINISHED_LIVING_INDEX])
                - Integer.parseInt(data[BEGAN_TO_LIVE_INDEX]);
    }
}
