package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MAX_YEARS = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] livedInUkraine = candidate.getPeriodsInUkr().split("-");
        int fromYears = Integer.parseInt(livedInUkraine[0]);
        int toYears = Integer.parseInt(livedInUkraine[1]);
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MAX_YEARS
                && toYears - fromYears >= YEARS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
