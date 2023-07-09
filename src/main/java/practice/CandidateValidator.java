package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_PERIOD_IN_UKR = 10;
    private static final int INDEX_PERIOD_FROM = 0;
    private static final int INDEX_PERIOD_TO = 1;
    private static final String ALLOWED_NATIONALITY = "Ukrainian";
    private static final String LINE_SPLITERATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(ALLOWED_NATIONALITY)
                && periodInUkr(candidate) >= MIN_PERIOD_IN_UKR;
    }

    private int periodInUkr(Candidate candidate) {
        String periodInUkr = candidate.getPeriodsInUkr();
        String[] periodFromTo = periodInUkr.split(LINE_SPLITERATOR);
        Integer yearFromInUkr = Integer.parseInt(periodFromTo[INDEX_PERIOD_FROM]);
        Integer yearToInUkr = Integer.parseInt(periodFromTo[INDEX_PERIOD_TO]);
        return yearToInUkr - yearFromInUkr;
    }
}
