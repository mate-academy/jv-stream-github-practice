package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_AMOUNT_OF_YEARS_LIVING_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] inUkraineFromAndTill = candidate.getPeriodsInUkr().split("-");
        int inUkraineFrom = Integer.parseInt(inUkraineFromAndTill[0]);
        int inUkraineTill = Integer.parseInt(inUkraineFromAndTill[1]);
        int yearsInUkraine = inUkraineTill - inUkraineFrom;
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && yearsInUkraine >= MIN_AMOUNT_OF_YEARS_LIVING_IN_UKRAINE;
    }
}
