package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final String COMPULSORY_NATIONALITY = "Ukrainian";
    private static final int MINIMAL_SUFFICIENT_AGE = 35;
    private static final int MINIMAL_PERIOD_LIVING_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String [] yearsInUkraine = candidate.getPeriodsInUkr().split("-");
        int arrivalData = Integer.parseInt(yearsInUkraine[0]);
        int departureData = Integer.parseInt(yearsInUkraine[1]);
        return candidate.getAge() >= MINIMAL_SUFFICIENT_AGE
                && candidate.getNationality().equals(COMPULSORY_NATIONALITY)
                && candidate.isAllowedToVote()
                && departureData - arrivalData >= MINIMAL_PERIOD_LIVING_IN_UKRAINE;
    }
}
