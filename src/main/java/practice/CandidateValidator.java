package practice;

import java.util.function.Predicate;
import java.util.stream.Stream;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String CANDIDATES_NATIONALITY = "Ukrainian";
    private static final int MIN_PERIOD_IN_UKRAINE = 10;
    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String YEARS_DELIM = "-";

    @Override
    public boolean test(Candidate candidate) {
        int[] candidatePeriod = Stream.of(candidate.getPeriodsInUkr().split(YEARS_DELIM))
                .mapToInt(Integer::parseInt)
                .toArray();
        int periodTime = candidatePeriod[1] - candidatePeriod[0];
        return candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATES_NATIONALITY)
                && periodTime >= MIN_PERIOD_IN_UKRAINE;
    }
}
