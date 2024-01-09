package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MINIMAL_YEARS = 10;
    private static final int INDEX_OF_YEAR_FROM = 0;
    private static final int INDEX_OF_YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        int livingFrom = Integer.parseInt(
                candidate.getPeriodsInUkr().split("-")[INDEX_OF_YEAR_FROM]);
        int livingTo = Integer.parseInt(
                candidate.getPeriodsInUkr().split("-")[INDEX_OF_YEAR_TO]);
        return (livingTo - livingFrom) >= MINIMAL_YEARS;
    }
}
