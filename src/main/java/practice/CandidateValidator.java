package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String UA_NATIONALITY = "Ukrainian";
    private static final int INDEX_YEAR_LIVE_FROM = 0;
    private static final int INDEX_YEAR_LIVE_TO = 1;
    private static final int MIN_PERIOD_IN_UA = 10;
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String CHAR_FOR_SPLIT = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split(CHAR_FOR_SPLIT);
        int periodInUkraine
                = Integer.parseInt(split[INDEX_YEAR_LIVE_TO])
                - Integer.parseInt(split[INDEX_YEAR_LIVE_FROM]);
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(UA_NATIONALITY)
                && periodInUkraine >= MIN_PERIOD_IN_UA;
    }
}
