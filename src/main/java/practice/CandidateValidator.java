package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int PERIOD = 10;
    private static final int MIN_AGE = 35;
    private static final String SYMBOL = "-";
    private static final int FROM = 0;
    private static final int TO = 1;

    private final static String NATION = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] split1 = candidate.getPeriodsInUkr().split(SYMBOL);
        int period = Math.abs(Integer.parseInt(split1[FROM]) - Integer.parseInt(split1[TO]));
        if (candidate.isAllowedToVote() && candidate.getAge() >= MIN_AGE
                && candidate.getNationality().equals(NATION)
                && period > PERIOD) {
            return true;
        }
        return false;
    }
    //write your code here

}
