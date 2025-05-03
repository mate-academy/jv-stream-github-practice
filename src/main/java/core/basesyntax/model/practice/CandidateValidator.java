package core.basesyntax.model.practice;

import core.basesyntax.model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEAR_IN_UKR = 10;
    private static final int INDEX_START_YEAR = 0;
    private static final int INDEX_END_YEAR = 1;
    private static final String DATE_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] yearStr = candidate.getPeriodsInUkr().split(DATE_SEPARATOR);
        int startYear = Integer.parseInt(yearStr[INDEX_START_YEAR]);
        int endYear = Integer.parseInt(yearStr[INDEX_END_YEAR]);
        int yearsInUkraine = endYear - startYear + 1;
        return yearsInUkraine >= MIN_YEAR_IN_UKR;
    }
}
