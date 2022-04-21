package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int AGE = 35;
    public static final int YEARS_IN_UKRAINE = 10;
    public static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkr(candidate.getPeriodsInUkr()) >= YEARS_IN_UKRAINE;
    }

    private int periodInUkr(String period) {
        String[] periodFromTo = period.split("-");
        return Integer.parseInt(periodFromTo[1]) - Integer.parseInt(periodFromTo[0]);
    }
}
