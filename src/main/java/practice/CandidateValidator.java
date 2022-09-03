package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate {
    private static final int MIN_AGE = 35;
    private static final int NEEDED_PERIOD = 10;
    private static final String NEEDED_NATION = "Ukrainian";

    @Override
    public boolean test(Object candidate) {
        Candidate current = (Candidate) candidate;
        return current.getAge() >= MIN_AGE
                && current.isAllowedToVote()
                && current.getNationality() == NEEDED_NATION
                && getPeriodsInUkr(current) >= NEEDED_PERIOD;
    }

    private int getPeriodsInUkr(Candidate candidate) {
        String[] splitedData = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(splitedData[1]) - Integer.parseInt(splitedData[0]);
    }
}
