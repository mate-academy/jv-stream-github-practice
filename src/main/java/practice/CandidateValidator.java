package practice;

import java.util.Arrays;
import java.util.function.Function;
import java.util.function.Predicate;
import model.Candidate;

/**
 * The requirements are: person should be older than 35 years, should be allowed to vote,
 * have nationality - 'Ukrainian'
 * and live in Ukraine for 10 years. For the last requirement use field periodsInUkr,
 * which has following view: "2002-2015"
 * We want to reuse our validation in future, so let's write our own impl of Predicate
 * parametrized with Candidate in CandidateValidator.
 */
public class CandidateValidator implements Predicate<Candidate> {
    private static final String YEAR_SEPARATOR = "-";
    private static final int CANDIDATE_MIN_AGE = 35;
    private static final int CANDIDATE_MIN_PERIOD_IN_UKRAINE = 10;
    private static final int INDEX_END_PERIOD = 1;
    private static final int INDEX_BEGIN_PERIOD = 0;

    @Override
    public boolean test(Candidate candidate) {
        Function<String, int[]> parse = data
                -> Arrays.stream(data.split(YEAR_SEPARATOR))
                    .mapToInt(Integer::parseInt)
                    .toArray();

        Predicate<int[]> delta = array
                -> array[INDEX_END_PERIOD] - array[INDEX_BEGIN_PERIOD]
                    >= CANDIDATE_MIN_PERIOD_IN_UKRAINE;

        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote()
                && delta.test(parse.apply(candidate.getPeriodsInUkr()));
    }
}
