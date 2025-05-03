package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsOfStayInUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(yearsOfStayInUkraine[1])
                - Integer.parseInt(yearsOfStayInUkraine[0]) >= MIN_PERIOD
                && candidate.isAllowedToVote();
    }
}
