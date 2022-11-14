package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_AGE = 35;
    private static final int MIN_YEAR_IN_UA = 10;
    private static final String BEST_NATIONALITY = "Ukrainian";

    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null
                || !candidate.isAllowedToVote()
                || candidate.getAge() < MIN_AGE
                || !candidate.getNationality().equals(BEST_NATIONALITY)) {
            return false;
        }
        String[] tmp = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(tmp[1]) - Integer.parseInt(tmp[0]) >= MIN_YEAR_IN_UA;
    }
}
