package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE_FOR_CANDIDATE = 35;
    private static final int MIN_YEAR_LIVE_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_CANDIDATE && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[1])
                - (Integer.parseInt(candidate.getPeriodsInUkr()
                .split("-")[0])) > MIN_YEAR_LIVE_IN_UKRAINE);
    }
    //write your code here
}
