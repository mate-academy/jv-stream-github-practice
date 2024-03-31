package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_PRESIDENT_POSITION = 35;
    private static final String NEEDED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int periodCandidateInUkr = getPeriodCandidate(candidate.getPeriodsInUkr());
        return candidate.getAge() >= MIN_AGE_FOR_PRESIDENT_POSITION
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NEEDED_NATIONALITY)
                && periodCandidateInUkr >= MIN_PERIOD;
    }

    int getPeriodCandidate(String periods) {
        String [] periodFromTo = periods.split(SEPARATOR);
        int periodFrom = Integer.parseInt(periodFromTo[0]);
        int periodTo = Integer.parseInt(periodFromTo[1]);
        return periodTo - periodFrom;
    }
}
