package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_YEARS = 10;
    private static final int MIN_AGE_CANDIDATE = 10;
    private static final int INDEX_ONE = 0;
    private static final int INDEX_TWO = 1;
    private static final String REGEX = "-";

    @Override
    public boolean test(Candidate candidate) {
        String periodFact = candidate.getPeriodsInUkr();
        String[] arrayYears = periodFact.split(REGEX);
        return (candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && (Integer.parseInt(arrayYears[INDEX_TWO])
                - Integer.parseInt(arrayYears[INDEX_ONE])) >= PERIOD_YEARS);
    }
}
