package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String UKRAINIAN = "Ukrainian";
    public static final String REGEX_PERIODS = "-";
    public static final int MIN_AGE_LIMIT = 35;
    public static final int MIN_PERIODS = 10;
    public static final int INDEX_END_PERIOD = 1;
    public static final int INDEX_BEGIN_PERIOD = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split(REGEX_PERIODS);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE_LIMIT
                && candidate.getNationality().equals(UKRAINIAN)
                && Integer.parseInt(periodsInUkr[INDEX_END_PERIOD])
                - Integer.parseInt(periodsInUkr[INDEX_BEGIN_PERIOD]) >= MIN_PERIODS;
    }
}
