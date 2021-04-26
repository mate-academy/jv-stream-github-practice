package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator<T> implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && yearsInTheCountry(candidate) >= 10;
    }

    public int yearsInTheCountry(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split(SPLITTER);
        return Integer.parseInt(periodsInUkr[TO_YEAR]) - Integer.parseInt(periodsInUkr[FROM_YEAR]);
    }
}
