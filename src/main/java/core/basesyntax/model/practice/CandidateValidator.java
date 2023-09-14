package core.basesyntax.model.practice;

import core.basesyntax.model.Candidate;
import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEAR_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearStr = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(yearStr[0]);
        int endYear = Integer.parseInt(yearStr[1]);
        int yearsInUkraine = endYear - startYear + 1;
        return yearsInUkraine >= MIN_YEAR_IN_UKR;
    }
}
