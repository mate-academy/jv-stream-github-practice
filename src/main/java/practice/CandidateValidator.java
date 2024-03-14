package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ALLOWED_AGE = 35;
    private static final boolean ALLOWED_TO_VOTE = true;
    private static final String NATIONALITY = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int firstDate = Integer.parseInt(periodsInUkr[0]);
        int secondDate = Integer.parseInt(periodsInUkr[1]);
        return secondDate - firstDate >= YEARS_IN_UKRAINE
                && candidate.isAllowedToVote() == ALLOWED_TO_VOTE
                && candidate.getAge() >= ALLOWED_AGE
                && candidate.getNationality().equals(NATIONALITY);
    }
    //write your code here
}
