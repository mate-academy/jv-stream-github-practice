package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMUM_YEARS_OLD = 35;
    private static final int MINIMUM_YEARS_IN_UA = 10;
    private static final String RIGHT_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        int startOfStayInUA = Integer.parseInt(candidate.getPeriodsInUkr().substring(0, 4));
        int endOfStayInUA = Integer.parseInt(candidate.getPeriodsInUkr().substring(5, 9));
        int yearsInUA = endOfStayInUA - startOfStayInUA;
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MINIMUM_YEARS_OLD
                && candidate.getNationality().equals(RIGHT_NATIONALITY)
                && yearsInUA >= MINIMUM_YEARS_IN_UA;
    }
}
