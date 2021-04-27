package practice;

import java.time.Year;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEAR = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUA = candidate.getPeriodsInUkr().split("-");
        int yearPeriod = Integer.parseInt(yearsInUA[1]) - Integer.parseInt(yearsInUA[0]);
        return candidate.getAge() >= MIN_YEAR
                && candidate.getNationality().equals(NATIONALITY)
                && yearPeriod >= YEARS_LIVE_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
