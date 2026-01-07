package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String REQUIRED_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;
    private static final String PERIOD_DELIMITER = "-";
    private static final int MIN_YEARS_OLD = 35;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_YEARS_OLD
                && candidate.isAllowedToVote()
                && REQUIRED_NATIONALITY.equals(candidate.getNationality())
                && livedInUkraineEnough(candidate.getPeriodsInUkr());
    }

    private boolean livedInUkraineEnough(String period) {
        String[] years = period.split(PERIOD_DELIMITER);
        int from = Integer.parseInt(years[0]);
        int to = Integer.parseInt(years[1]);
        return to - from >= MIN_YEARS_IN_UKRAINE;
    }
}
