package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int FROM_YEAR_POSITION = 0;
    private static final int TO_YEAR_POSITION = 1;
    private static final int MIN_YEARS_IN_UA = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodYears = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(periodYears[TO_YEAR_POSITION])
                - Integer.parseInt(periodYears[FROM_YEAR_POSITION]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && period >= MIN_YEARS_IN_UA;
    }
}
