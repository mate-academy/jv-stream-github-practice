package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int MINIMAL_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final int MINIMAL_PERIOD_IN_UKRAINE = 10;
    public static final String SPLITTER = "-";
    public static final int TO_PERIOD_INDEX = 1;
    public static final int FROM_PERIOD_INDEX = 0;

    public boolean test(Candidate candidate) {
        int[] periodsInUkr = Arrays.stream(candidate.getPeriodsInUkr().split(SPLITTER))
                .mapToInt(Integer::parseInt)
                .toArray();
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MINIMAL_AGE
                && periodsInUkr[TO_PERIOD_INDEX] - periodsInUkr[FROM_PERIOD_INDEX]
                    >= MINIMAL_PERIOD_IN_UKRAINE;
    }
}
