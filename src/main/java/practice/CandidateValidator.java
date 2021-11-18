package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final String REQUIRED_COUNTRY = "Ukrainian";
    public static final int MIN_PERIOD_IN_UK = 10;

    @Override
    public boolean test(Candidate candidate) {
        return getPeriodFromStringRange(candidate.getPeriodsInUkr()) >= MIN_PERIOD_IN_UK
                && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(REQUIRED_COUNTRY)
                && candidate.isAllowedToVote();
    }

    private int getPeriodFromStringRange(String range) {
        String[] fromTo = range.split("-");
        int from = Integer.parseInt(fromTo[0]);
        int to = Integer.parseInt(fromTo[1]);
        return to - from;
    }
}
