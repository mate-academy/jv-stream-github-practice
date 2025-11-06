package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UKRAINIAN_NATIONALITY = "Ukrainian";
    private static final int PRESIDENT_FROM_AGE = 35;
    private static final int LIVE_IN_UKRAINE = 10;

    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split("-");
        int yearsInUkr = Integer.parseInt(periodInUkr[1]) - Integer.parseInt(periodInUkr[0]);
        return candidate.getAge() >= PRESIDENT_FROM_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UKRAINIAN_NATIONALITY)
                && yearsInUkr >= LIVE_IN_UKRAINE;
    }
}
