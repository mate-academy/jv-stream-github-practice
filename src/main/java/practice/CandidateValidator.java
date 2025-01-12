package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private final static int PERIOD = 10;
    private final static int MIN_AGE = 35;
    private final static String SYMBOL = "-";
    private final static int FROM = 0;
    private final static int TO = 1;

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
