package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String YEARS_SEPARATOR = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_YEARS_OF_LIVING = 10;
    private static final int START_INDEX = 0;
    private static final int FINAL_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] fromToDate = candidate.getPeriodsInUkr().split(YEARS_SEPARATOR);
        int yearFrom = Integer.parseInt(fromToDate[START_INDEX]);
        int yearTo = Integer.parseInt(fromToDate[FINAL_INDEX]);
        return candidate.getNationality().equals(NATIONALITY)
                && candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && (yearTo - yearFrom) >= MIN_YEARS_OF_LIVING;
    }
}
