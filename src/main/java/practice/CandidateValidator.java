package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int AGE = 35;
    private static final int YEARS_IN_UKRAINE = 10;
    private static final int YEAR_IN_UKRAINE_TO = 1;
    private static final int YEAR_IN_UKRAINE_FROM = 0;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(years[YEAR_IN_UKRAINE_TO])
                        - Integer.parseInt(years[YEAR_IN_UKRAINE_FROM]) >= YEARS_IN_UKRAINE;
    }
}
