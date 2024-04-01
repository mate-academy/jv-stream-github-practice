package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String periodsInUkr = candidate.getPeriodsInUkr();
        String[] years = periodsInUkr.split("-");
        int periodInUkrFrom = Integer.parseInt(years[0]);
        int periodInUkrTo = Integer.parseInt(years[1]);
        int periodInUkr = periodInUkrTo - periodInUkrFrom;

        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && periodInUkr >= MIN_PERIOD_IN_UKRAINE;
    }
}
