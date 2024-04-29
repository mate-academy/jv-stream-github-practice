package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MINIMAL_AGE = 35;
    private static final int FIRST_DATE = 0;
    private static final int SECOND_DATE = 1;
    private static final int MINIMAL_YEAR_IN_UKRAINE = 10;
    private int yearsInUkraine;

    @Override
    public boolean test(Candidate candidate) {
        String[] extractedDates = candidate.getPeriodsInUkr().split("-");
        yearsInUkraine = Integer.parseInt(extractedDates[SECOND_DATE])
                - Integer.parseInt(extractedDates[FIRST_DATE]);
        if (candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMAL_AGE
                && yearsInUkraine >= MINIMAL_YEAR_IN_UKRAINE) {
            return true;
        }
        return false;
    }
}
