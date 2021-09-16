package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int ALLOWED_AGE = 35;
    private static final int ALLOWED_PERIOD = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return candidate.getAge() >= ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && period >= ALLOWED_PERIOD;
    }
}
