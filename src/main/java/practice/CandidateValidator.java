package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPARATOR = "-";
    private static final int START_YEAR = 0;
    private static final int END_YEAR = 1;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && wasPeriodInUkraineMoreTenYear(candidate.getPeriodsInUkr());
    }

    private boolean wasPeriodInUkraineMoreTenYear(String periodInUkraine) {
        String[] periodSplited = periodInUkraine.split(SEPARATOR);
        return Integer.parseInt(periodSplited[END_YEAR])
                - Integer.parseInt(periodSplited[START_YEAR]) >= 10;

    }
    //write your code here
}
