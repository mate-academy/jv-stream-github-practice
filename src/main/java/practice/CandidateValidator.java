package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final int MIN_AGE_VOTE_PRESIDENT = 35;
    private static final String NATIONALITY_PRESIDENT = "Ukrainian";
    private static final int MIN_PERIOD_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_VOTE_PRESIDENT
                && candidate.getNationality().equals(NATIONALITY_PRESIDENT)
                && candidate.isAllowedToVote()
                && wasPeriodInUkraineMoreTenYear(candidate.getPeriodsInUkr());
    }

    private boolean wasPeriodInUkraineMoreTenYear(String periodInUkraine) {
        String[] periodSplited = periodInUkraine.split(SEPARATOR);
        return Integer.parseInt(periodSplited[END_YEAR_INDEX])
                - Integer.parseInt(periodSplited[START_YEAR_INDEX]) >= MIN_PERIOD_LIVE_IN_UKRAINE;

    }
    //write your code here
}
