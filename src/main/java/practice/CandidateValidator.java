package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_LIVE_IN_COUNTRY = 10;
    private static final int YEAR_FROM = 0;
    private static final int YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int thisYear = Integer.parseInt(years[YEAR_TO]) - Integer.parseInt(years[YEAR_FROM]) + 1;
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (thisYear >= MIN_YEARS_LIVE_IN_COUNTRY);
    }
}
