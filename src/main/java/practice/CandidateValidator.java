package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_THRESHOLD = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_COUNTRY = 10;
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int period = Integer.parseInt(years[END_INDEX]) - Integer.parseInt(years[BEGIN_INDEX]);
        return candidate.getAge() >= AGE_THRESHOLD
                && candidate.getNationality().equals(NATIONALITY)
                && period >= YEARS_IN_COUNTRY
                && candidate.isAllowedToVote();
    }
}
