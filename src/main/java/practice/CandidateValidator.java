package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String SEPERATOR = "-";
    private static final String NATIONALITI = "Ukrainian";
    private static final int MIN_PERIOD = 10;
    private static final int MIN_AGE = 35;
    private static final int FROM_YER = 0;
    private static final int TO_YER = 1;

    @Override
    public boolean test(Candidate candidate) {
        String [] years = candidate.getPeriodsInUkr().split(SEPERATOR);
        int periodsInUkr = Integer.parseInt(years[TO_YER]) - Integer.parseInt(years[FROM_YER]);

        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITI)
                && periodsInUkr >= MIN_PERIOD;
    }
    //write your code here
}
