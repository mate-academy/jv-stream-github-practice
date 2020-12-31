package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int OLDER_THEN = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT_REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= OLDER_THEN
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && periodInUkraine(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UKRAINE;
    }

    private int periodInUkraine(String period) {
        String[] yearsInUkraine = period.split(SPLIT_REGEX);
        return Integer.parseInt(yearsInUkraine[1])
                - Integer.parseInt(yearsInUkraine[0]);
    }
}
