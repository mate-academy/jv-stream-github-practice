package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int DIFFERENCE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DASH = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(DASH);
        int difference = Integer.parseInt(periodInUkr[ONE]) - Integer.parseInt(periodInUkr[ZERO]);
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && difference >= DIFFERENCE;
    }
}
