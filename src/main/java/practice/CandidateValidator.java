package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int LIVE_IN_UKRAINE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SEPARATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        int periodInUkr = 0;
        for (String s : candidate.getPeriodsInUkr().split(SEPARATOR)) {
            int i = Integer.parseInt(s);
            periodInUkr = i - periodInUkr;
        }
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodInUkr >= LIVE_IN_UKRAINE;

    }



    //write your code here
}
