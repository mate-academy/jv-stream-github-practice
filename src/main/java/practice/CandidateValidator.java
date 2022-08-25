package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int OLDER_THAN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX = "-";
    private static final int START_PERIOD = 0;
    private static final int END_PERIOD = 1;
    private static final int MIN_TOTAL_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= OLDER_THAN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(candidate.getPeriodsInUkr().split(REGEX)[END_PERIOD])
                - Integer.parseInt(candidate.getPeriodsInUkr().split(REGEX)[START_PERIOD])
                >= MIN_TOTAL_PERIOD_IN_UKRAINE);
    }
}
