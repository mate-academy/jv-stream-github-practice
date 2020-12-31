package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int AGE_LIMIT = 35;
    public static final int YEARS_IN_UKRAINE = 10;
    public static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int fromYear = Integer.parseInt(candidate.getPeriodsInUkr()
                        .substring(candidate.getPeriodsInUkr().indexOf("-") + 1));
        int toYear = Integer.parseInt(candidate.getPeriodsInUkr()
                        .substring(0, candidate.getPeriodsInUkr().indexOf("-")));
        return candidate.getAge() >= AGE_LIMIT
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && fromYear - toYear > YEARS_IN_UKRAINE;
    }
}
