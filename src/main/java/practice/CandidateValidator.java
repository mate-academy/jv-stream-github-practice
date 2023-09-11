package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEAR = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_LIVE_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";
    private static final int FIRST_PART_OF_PERIOD_IN_UKR = 0;
    private static final int SECOND_PART_OF_PERIOD_IN_UKR = 1;

    @Override
    public boolean test(Candidate candidate) {
        int liveInUkraine = Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SEPARATOR)[SECOND_PART_OF_PERIOD_IN_UKR])
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .split(SEPARATOR)[FIRST_PART_OF_PERIOD_IN_UKR]);
        return (candidate.getAge() >= MIN_YEAR && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && liveInUkraine >= MIN_LIVE_IN_UKRAINE);
    }
}
