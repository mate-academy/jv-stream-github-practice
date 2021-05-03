package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_MINIMUM_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MINIMUM_YEARS_STRAIGHT_IN_UKRAINE = 10;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(SEPARATOR);
        int stayPeriod = Integer.parseInt(yearsInUkraine[1]) - Integer.parseInt(yearsInUkraine[0]);
        return candidate.getAge() >= REQUIRED_MINIMUM_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && stayPeriod >= MINIMUM_YEARS_STRAIGHT_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
