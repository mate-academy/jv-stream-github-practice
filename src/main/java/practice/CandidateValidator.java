package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String years = candidate.getPeriodsInUkr();
        int periodsInUkr = Integer.parseInt(years.substring(years.indexOf(SEPARATOR) + 1))
                - Integer.parseInt(years.substring(0, years.indexOf(SEPARATOR)));
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodsInUkr >= MIN_PERIOD;
    }
}
