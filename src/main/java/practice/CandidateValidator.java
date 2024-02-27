package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_TO_CANDIDATE_PRESIDENT = 35;
    private static final int FROM_YEAR_LIVE = 0;
    private static final int TO_YEAR_LIVE = 1;
    private static final int SUFFICIENT_PERIOD = 10;
    private static final String COUNTRY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        boolean periodInUkr =
                calculatorYearsLivedInUkraine(candidate.getPeriodsInUkr()) > SUFFICIENT_PERIOD;
        return candidate.getAge() >= MIN_AGE_TO_CANDIDATE_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(COUNTRY)
                && periodInUkr;
    }

    private int calculatorYearsLivedInUkraine(String string) {
        String[] splitString = string.split("-");
        int from = Integer.parseInt(splitString[FROM_YEAR_LIVE]);
        int to = Integer.parseInt(splitString[TO_YEAR_LIVE]);
        return to - from;
    }
}
