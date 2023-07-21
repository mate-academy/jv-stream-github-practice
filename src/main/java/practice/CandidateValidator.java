package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int LIVE_IN_UKRAINE_MIN = 10;
    private static final int INDEX_LIVE_IN_UKRAINE_FROM = 0;
    private static final int INDEX_LIVE_IN_UKRAINE_TO = 1;
    private static final String NATIONALITY = "Ukrainian";
    private static final String DATE_SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(DATE_SPLITTER);
        int dateLiveInUkraineFrom = Integer.parseInt(periodInUkraine[INDEX_LIVE_IN_UKRAINE_FROM]);
        int dateLiveInUkraineTo = Integer.parseInt(periodInUkraine[INDEX_LIVE_IN_UKRAINE_TO]);
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && dateLiveInUkraineTo - dateLiveInUkraineFrom >= LIVE_IN_UKRAINE_MIN;
    }
}
