package practice;

import java.util.function.Function;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<model.Candidate> {
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int REQUIRED_PERIOD = 10;
    private static final String SPLITTER = "-";
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        Function<Candidate, Integer> periodCalculate = c -> {
            String[] years = c.getPeriodsInUkr().split(SPLITTER);
            return Integer.parseInt(years[TO_YEAR]) - Integer.parseInt(years[FROM_YEAR]);
        };
        return candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote()
                && periodCalculate.apply(candidate) >= REQUIRED_PERIOD;
    }
}
