package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int START_PERIOD_IN_UKRAINE_INDEX = 0;
    private static final int END_PERIOD_IN_UKRAINE_INDEX = 1;
    private static final String SPLITERATOR = "-";
    private static final String NATIONALITY = "Ukrainian";
    private static final int ACCESS_AGE = 35;
    private static final int ACCESS_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ACCESS_AGE && candidate.isAllowedToVote()
                && timeInUkraine(candidate.getPeriodsInUkr()) > ACCESS_PERIOD_IN_UKRAINE
                && candidate.getNationality().equals(NATIONALITY);
    }

    private int timeInUkraine(String period) {
        String[] years = period.split(SPLITERATOR);
        int start = Integer.parseInt(years[START_PERIOD_IN_UKRAINE_INDEX]);
        int end = Integer.parseInt(years[END_PERIOD_IN_UKRAINE_INDEX]);
        return end - start;
    }
}
