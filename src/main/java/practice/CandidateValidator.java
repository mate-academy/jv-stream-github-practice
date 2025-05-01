package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String DASH = "-";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_IN_COUNTRY = 10;
    private static final int LIVED_FROM_INDEX = 0;
    private static final int LIVED_TO_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(DASH);
        final int livedFrom = Integer.parseInt(periods[LIVED_FROM_INDEX]);
        final int livedTo = Integer.parseInt(periods[LIVED_TO_INDEX]);
        return candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && livedTo - livedFrom >= MIN_YEARS_IN_COUNTRY;
    }
}
