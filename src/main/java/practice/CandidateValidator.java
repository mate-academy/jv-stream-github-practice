package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T> implements Predicate {
    private static final int MIN_VALID_AGE_FOR_PRESIDENT = 35;
    private static final int MIN_LIVING_PERIOD = 10;
    private static final String CANDIDAT_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Object o) {
        Candidate candidate = (Candidate) o;
        String[] livingPeriod = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(livingPeriod[1])
                - Integer.parseInt(livingPeriod[0]);
        if (candidate.getAge() >= MIN_VALID_AGE_FOR_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDAT_NATIONALITY)
                && periodInUkr >= MIN_LIVING_PERIOD) {
            return true;
        }
        return false;
    }
}
