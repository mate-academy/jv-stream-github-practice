package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_PERIOD = 10;
    public static final int MIN_OLD_YEARS = 35;
    public static final String NATIONALS = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        final int split1 = Integer.parseInt(split[1]);
        final int split2 = Integer.parseInt(split[0]);
        final int different = split1 - split2;
        if (candidate.getAge() >= MIN_OLD_YEARS
                && candidate.getNationality().equalsIgnoreCase(NATIONALS)
                && different >= MIN_PERIOD) {
            return candidate.isAllowedToVote();
        }
        return false;
    }
}
