package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_PRESIDENTS_AGE = 35;
    private static final int ZERO_ELEMENTS = 0;
    private static final int FIRST_ELEMENT = 1;
    private static final int DIFFERENCE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DASH = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split(DASH);
        int difference = Integer.parseInt(periodInUkr[FIRST_ELEMENT]) - Integer.parseInt(periodInUkr[ZERO_ELEMENTS]);
        return candidate.getAge() >= MINIMUM_PRESIDENTS_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && difference >= DIFFERENCE;
    }
}
