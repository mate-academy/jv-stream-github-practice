package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String YEARS_SPLITTER = "-";
    private static final int VALID_AGE = 35;
    private static final int END_YEAR_INDEX = 1;
    private static final int START_YEAR_INDEX = 0;
    private static final int MINIMAL_RESIDENCE_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraine = candidate.getPeriodsInUkr().split(YEARS_SPLITTER);
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= VALID_AGE
                && candidate.isAllowedToVote()
                && Integer.parseInt(yearsInUkraine[END_YEAR_INDEX])
                - Integer.parseInt(yearsInUkraine[START_YEAR_INDEX]) >= MINIMAL_RESIDENCE_YEARS;
    }
}
