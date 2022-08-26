package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        if (candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && period >= MIN_PERIOD_IN_UKRAINE) {
            return true;
        }
        return false;
    }
}
