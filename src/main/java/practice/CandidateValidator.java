package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int CANDIDATE_MIN_YEARS_OLD = 35;
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String CANDIDATE_CITIZENSHIP = "Ukrainian";
    private static final String SEPARATOR = "-";
    private static final int BEGIN_INDEX = 0;
    private static final int END_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_MIN_YEARS_OLD
                && candidate.isAllowedToVote()
                && CANDIDATE_CITIZENSHIP.equals(candidate.getNationality())
                && calculateYearsInUkraine(candidate.getPeriodsInUkr()) >= MIN_YEARS_IN_UKRAINE;
    }

    private static int calculateYearsInUkraine(String periods) {
        int totalYears = 0;
        if (periods.contains(SEPARATOR)) {
            String[] parts = periods.split(SEPARATOR);
            if (parts.length == 2) {
                int startYear = Integer.parseInt(parts[BEGIN_INDEX]);
                int endYear = Integer.parseInt(parts[END_INDEX]);
                totalYears = endYear - startYear;
            }
        }
        return totalYears;
    }
}
