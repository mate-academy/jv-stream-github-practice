package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final int START_LIVE_IN_UKRAINE = 0;
    private static final int FINISH_LIVE_IN_UKRAINE = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate person) {
        String[] periodsInUkr = person.getPeriodsInUkr().split("-");
        int yearsInUkr = Integer.parseInt(periodsInUkr[FINISH_LIVE_IN_UKRAINE])
                - Integer.parseInt(periodsInUkr[START_LIVE_IN_UKRAINE]);
        return person.getAge() >= MIN_AGE_FOR_CANDIDATE
                && person.isAllowedToVote()
                && person.getNationality().equals(NATIONALITY)
                && yearsInUkr >= MIN_YEARS_IN_UKRAINE;
    }
}
