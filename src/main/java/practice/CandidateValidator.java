package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInCountry(candidate.getPeriodsInUkr()) >= YEARS_IN_UKRAINE;
    }

    private int periodInCountry(String period) {
        String[] periodFromTo = period.split("-");
        return Integer.parseInt(periodFromTo[1]) - Integer.parseInt(periodFromTo[0]);
    }
}
