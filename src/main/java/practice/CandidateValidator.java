package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int CANDIDATE_AGE = 35;
    private static final String PERIOD_SEPARATOR = ",";
    private static final String PERIOD_MATCHER = "\\d{4}-\\d{4}";
    private static final String YEAR_SPLITTER = "-";
    private static final int YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && NATIONALITY.equals(candidate.getNationality())
                && hasLivedInUkraineForTenYears(candidate.getPeriodsInUkr());
    }

    private boolean hasLivedInUkraineForTenYears(String periodsInUkr) {
        if (periodsInUkr == null || periodsInUkr.isEmpty()) {
            return false;
        }

        return Arrays.stream(periodsInUkr.split(PERIOD_SEPARATOR))
                .map(String::trim)
                .filter(s -> s.matches(PERIOD_MATCHER))
                .mapToInt(period -> {
                    String[] years = period.split(YEAR_SPLITTER);
                    int start = Integer.parseInt(years[0]);
                    int end = Integer.parseInt(years[1]);
                    return end - start;
                })
                .sum() >= YEARS_IN_UKRAINE;
    }

}
