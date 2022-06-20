package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int FIRST_INDEX = 1;
    public static final int SECOND_INDEX = 0;
    public static final String REGEX = "-";
    public static final String NATIONALITY_OF_UKRAINE = "Ukrainian";
    public static final int MIN_AGE_CANDIDATE = 35;
    public static final int MIN_NUMBER_OF_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkraine = candidate.getPeriodsInUkr().split(REGEX);
        return candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_OF_UKRAINE)
                && (Integer.valueOf(periodInUkraine[FIRST_INDEX])
                - Integer.valueOf(periodInUkraine[SECOND_INDEX])) >= MIN_NUMBER_OF_YEARS;
    }
}
