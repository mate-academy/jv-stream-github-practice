package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int REQUIRED_AGE = 35;
    private static final int REQUIRED_YEARS_IN_THE_COUNTRY = 10;
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= REQUIRED_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && candidate.isAllowedToVote()
                && yearsInTheCountry(candidate) >= REQUIRED_YEARS_IN_THE_COUNTRY;
    }

    private int yearsInTheCountry(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split(SPLITTER);
        return Integer.parseInt(periodsInUkr[TO_YEAR]) - Integer.parseInt(periodsInUkr[FROM_YEAR]);
    }
}
