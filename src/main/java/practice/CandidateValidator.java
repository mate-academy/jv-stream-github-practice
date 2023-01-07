package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    static final int MIN_AGE = 35;
    static final int INDEX_START_PERIOD = 0;
    static final int INDEX_END_PERIOD = 1;
    static final int MIN_LIVING_TIME = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_END_PERIOD])
                - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[INDEX_START_PERIOD]))
                >= MIN_LIVING_TIME;
    }
    //write your code here
}
