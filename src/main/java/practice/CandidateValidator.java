package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";
    private static final int INDEX_FROM_YEAR = 0;
    private static final int INDEX_TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && getYearsInUkraine(candidate) >= MIN_YEARS_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    private int getYearsInUkraine(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLITTER);
        return Integer.parseInt(years[INDEX_TO_YEAR]) - Integer.parseInt(years[INDEX_FROM_YEAR]);
    }
}
