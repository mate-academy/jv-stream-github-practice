package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final int MIN_AGE = 35;
    static final int MIN_YEARS_IN_UKRAINE = 10;
    static final String NATIONALITY_NEEDED = "Ukrainian";
    static final String SEPARATOR = "-";
    static final int BEGIN_INDEX = 0;
    static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_NEEDED)
                && calculateYearsInUkraine(candidate);
    }

    private boolean calculateYearsInUkraine(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(SEPARATOR);
        return Integer.parseInt(dates[END_INDEX])
                - Integer.parseInt(dates[BEGIN_INDEX]) >= MIN_YEARS_IN_UKRAINE;
    }
}
