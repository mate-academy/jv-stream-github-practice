package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String YEARS_SEPARATOR = "-";
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && calculateYearsStayingInUkraine(candidate);

    }

    private boolean calculateYearsStayingInUkraine(Candidate candidate) {
        String[] dates = candidate.getPeriodsInUkr().split(YEARS_SEPARATOR);
        return Integer.parseInt(dates[END_INDEX])
                - Integer.parseInt(dates[BEGIN_INDEX]) >= YEARS_IN_UKRAINE;
    }
}
