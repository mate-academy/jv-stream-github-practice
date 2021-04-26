package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_LIVED_IN_UKRAINE = 10;
    private static final int REQUIRED_AGE = 35;
    private static final String YEAR_SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsLiveInUkraine = candidate.getPeriodsInUkr().split(YEAR_SPLITTER);
        int candidateLivedYears = Integer.parseInt(yearsLiveInUkraine[1])
                - Integer.parseInt(yearsLiveInUkraine[0]);
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidateLivedYears >= YEARS_LIVED_IN_UKRAINE;
    }
}
