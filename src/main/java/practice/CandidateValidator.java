package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int NEED_YEAR = 35;
    private static final String NEED_NATIONALITY = "Ukrainian";
    private static final int NEED_PERIOD_IN_UKRAINE = 10;
    private static final String YEARS_SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(YEARS_SPLITTER);
        int timeInUkraine = Integer.parseInt(yearsInUkraine[1])
                - Integer.parseInt(yearsInUkraine[0]);
        return candidate.getAge() >= NEED_YEAR
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NEED_NATIONALITY)
                && timeInUkraine >= NEED_PERIOD_IN_UKRAINE;
    }
}
