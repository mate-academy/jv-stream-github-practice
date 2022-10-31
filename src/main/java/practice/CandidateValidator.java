package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final String HYPHEN = "-";
    private static final int ADMISSIBLE_AGE = 35;
    private static final int RESIDENCE = 10;
    private static final int INDEX_BEFORE = 0;
    private static final int INDEX_AFTER = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ADMISSIBLE_AGE
                && candidate.isAllowedToVote()
                && getValue(candidate.getPeriodsInUkr())
                && candidate.getNationality().equals(NATIONALITY);
    }

    private boolean getValue(String period) {
        final String [] years = period.split(HYPHEN);
        final int givenPeriod;
        givenPeriod = Integer.parseInt(years[INDEX_AFTER]) - Integer.parseInt(years[INDEX_BEFORE]);
        return givenPeriod > RESIDENCE;
    }
}
