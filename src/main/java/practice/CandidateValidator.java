package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int REQUIRED_AGE = 35;
    public static final String REQUIRED_NATIONALITY = "Ukrainian";
    public static final int REQUIRED_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int yearsInUkraine = Integer.parseInt(periods[1]) - Integer.parseInt(periods[0]);

        return candidate.isAllowedToVote()
                && candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && yearsInUkraine >= REQUIRED_YEARS_IN_UKRAINE;
    }
}
