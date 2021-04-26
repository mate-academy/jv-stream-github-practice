package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_LIMIT = 35;
    private static final int WAS_IN_UKR_LIMIT = 10;
    private static final String SPLIT_ELEMENT = "-";
    private static final String CORRECT_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] years = periodsInUkr.split(SPLIT_ELEMENT);
        int yearsWasInUkraine = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);

        return candidate.getAge() >= AGE_LIMIT && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CORRECT_NATIONALITY)
                && yearsWasInUkraine > WAS_IN_UKR_LIMIT;
    }
}
