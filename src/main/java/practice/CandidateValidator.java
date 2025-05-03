package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE_FOR_PRESIDENT = 35;
    private static final int MIN_AGE_TO_LIVE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] parts = candidate.getPeriodsInUkr().split("-");
        int result = Integer.parseInt(parts[1]) - Integer.parseInt(parts[0]);
        return candidate.getAge() >= MIN_AGE_FOR_PRESIDENT
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && result >= MIN_AGE_TO_LIVE;
    }
    //write your code here
}
