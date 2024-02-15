package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE_FOR_CANDIDATE = 35;
    public static final String NATIONALITY_TO_VOTE = "Ukrainian";
    public static final int MIN_YEARS_TO_LIVE_IN_COUNTRY = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] fromToInUkraine = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY_TO_VOTE)
                && (Integer.parseInt(fromToInUkraine[1]) - Integer.parseInt(fromToInUkraine[0]))
                >= MIN_YEARS_TO_LIVE_IN_COUNTRY
                && candidate.isAllowedToVote();
    }
}
