package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int ENOUGH_PERIOD_OF_LIFE_IN_THE_COUNTRY = 10;
    private static final int ENOUGH_AGE = 35;
    private static final String SPLIT_STRING = "-";

    @Override
    public boolean test(Candidate candidate) {
        int periodLiveInUkraine = 0;
        for (String string : candidate.getPeriodsInUkr().split(SPLIT_STRING)) {
            periodLiveInUkraine += periodLiveInUkraine == 0
                    ? Integer.parseInt(string)
                    : -Integer.parseInt(string);
        }
        return candidate.getAge() >= ENOUGH_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Math.abs(periodLiveInUkraine) >= ENOUGH_PERIOD_OF_LIFE_IN_THE_COUNTRY;
    }
}
