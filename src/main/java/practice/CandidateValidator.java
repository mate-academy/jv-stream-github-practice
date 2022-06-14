package practice;

import model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private final static String NATIONALITY = "Ukrainian";
    private final static int PERIOD_YEARS = 10;
    private final static int MIN_AGE_CANDIDATE = 10;
    private final static int INDEX_ONE = 0;
    private final static int INDEX_TWO = 1;
    private final static String REGEX = "-";

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
