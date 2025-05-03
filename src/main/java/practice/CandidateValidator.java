package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int YEAR_FROM_POSITION = 0;
    private static final int YEAR_TOO_POSITION = 1;
    private static final String YEAR_SEPARATOR = "-";
    private static final int YEARS_IN_UKRAINE = 10;
    private static final int MINIMUM_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(YEAR_SEPARATOR);
        int livedInCountry = Integer.parseInt(years[YEAR_TOO_POSITION])
                - Integer.parseInt(years[YEAR_FROM_POSITION]);
        return candidate.getAge() >= MINIMUM_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && livedInCountry >= YEARS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }
}
