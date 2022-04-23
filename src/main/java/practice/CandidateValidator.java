package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final int PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] fromTo = candidate.getPeriodsInUkr().split("-");
        int periodInUkr = Integer.parseInt(fromTo[1]) - Integer.parseInt(fromTo[0]);
        return candidate.getAge() >= MIN_AGE
                && periodInUkr >= PERIOD_IN_UKRAINE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY);
    }
}
