package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int ACCEPTABLE_AGE = 35;
    private static final int YEARS_OF_RESIDENCE = 10;
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(years[START_YEAR]);
        int endYear = Integer.parseInt(years[END_YEAR]);
        return candidate.getAge() >= ACCEPTABLE_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && endYear - startYear >= YEARS_OF_RESIDENCE;
    }
}
