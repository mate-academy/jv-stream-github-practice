package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UA_NATIONALITY = "Ukrainian";
    private static final int INDEX_YEAR_LIVE_FROM = 0;
    private static final int INDEX_YEAR_LIVE_TO = 1;
    private static final int NECESSARY_PERIOD_IN_UA = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        int periodInUkraine
                = Integer.parseInt(split[INDEX_YEAR_LIVE_TO])
                - Integer.parseInt(split[INDEX_YEAR_LIVE_FROM]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UA_NATIONALITY)
                && periodInUkraine >= NECESSARY_PERIOD_IN_UA;
    }
}
