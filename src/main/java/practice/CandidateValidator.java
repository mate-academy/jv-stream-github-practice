package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int FROM_YEAR_INDEX = 0;
    public static final int LIVE_IN_UKR = 10;
    public static final int TILL_YEAR_INDEX = 1;
    public static final int VOTE_AGE = 35;
    public static final String NATIONALITY = "Ukrainian";
    public static final String YEAR_SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] periods = candidate.getPeriodsInUkr().split(YEAR_SEPARATOR);
        int periodLiveInUkr = Integer.parseInt(periods[TILL_YEAR_INDEX])
                - Integer.parseInt(periods[FROM_YEAR_INDEX]);
        return candidate.getAge() >= VOTE_AGE
                && periodLiveInUkr >= LIVE_IN_UKR
                && candidate.getNationality().equals(NATIONALITY)
                && candidate.isAllowedToVote();
    }
}
