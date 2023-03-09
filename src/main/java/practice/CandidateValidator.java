package practice;

import java.util.Arrays;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int MIN_AGE_FOR_CANDIDATES = 35;
    public static final String NATIONALITY_FOR_CANDIDATS = "Ukrainian";
    public static final String REGEX_FOR_PERIODS_IN_UKRAINE = "-";
    public static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.isAllowedToVote()
                && candidate.getAge() >= MIN_AGE_FOR_CANDIDATES
                && candidate.getNationality().equals(NATIONALITY_FOR_CANDIDATS)
                && Arrays.stream(candidate.getPeriodsInUkr().split(REGEX_FOR_PERIODS_IN_UKRAINE))
                    .mapToInt(Integer::valueOf)
                    .reduce(0, (yearFrom, yearTo) -> yearTo - yearFrom) > MIN_YEARS_IN_UKRAINE;
    }
    //write your code here
}
