package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_PRESIDENT_POSITION = 35;
    private static final String NEEDED_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final int INDEX_OF_START_DATE = 0;
    private static final int INDEX_OF_END_DATE = 1;
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int periodCandidateInUkr = getPeriodCandidate(candidate.getPeriodsInUkr());
        return candidate.getAge() >= MIN_AGE_FOR_PRESIDENT_POSITION
                && candidate.isAllowedToVote()
                && NEEDED_NATIONALITY.equals(candidate.getNationality())
                && periodCandidateInUkr >= MIN_PERIOD;
    }

    private int getPeriodCandidate(String periods) {
        String [] periodFromTo = periods.split(SEPARATOR);
        int periodFrom = Integer
                .parseInt(periodFromTo[INDEX_OF_START_DATE]);
        int periodTo = Integer
                .parseInt(periodFromTo[INDEX_OF_END_DATE]);
        return periodTo - periodFrom;
    }
}
