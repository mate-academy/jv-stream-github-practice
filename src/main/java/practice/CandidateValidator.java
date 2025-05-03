package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_YEAR = 1;
    private static final int OLD_YEAR = 0;
    private static final int LIVE_IN_UKRAINE_FOR_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && Integer.parseInt(years[START_YEAR])
                                - Integer.parseInt(years[OLD_YEAR]) >= LIVE_IN_UKRAINE_FOR_YEARS;
    }
}
