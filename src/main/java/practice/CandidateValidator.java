package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_LIVING = 10;
    private static final int MIN_YEARS = 35;
    private static final int SECOND_PERIOD = 1;
    private static final int FIRST_PERIOD = 0;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getNationality().equalsIgnoreCase(NATIONALITY)
                && candidate.getAge() >= MIN_YEARS
                && getPeriodsInUkrAsInt(candidate) >= MIN_YEARS_LIVING;
    }

    private int getPeriodsInUkrAsInt(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return Integer.valueOf(years[SECOND_PERIOD]) - Integer.valueOf(years[FIRST_PERIOD]);
    }
}
