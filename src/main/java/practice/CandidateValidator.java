package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int ACCEPTABLE_AGE = 35;
    private static final String ACCEPTABLE_NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";
    private static final int ACCEPTABLE_PERIOD_IN_UA = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ACCEPTABLE_AGE
                && candidate.getNationality().equals(ACCEPTABLE_NATIONALITY)
                && getPeriodInUa(candidate.getPeriodsInUkr()) >= ACCEPTABLE_PERIOD_IN_UA
                && candidate.isAllowedToVote();
    }

    private int getPeriodInUa(String periodInString) {
        String[] periodInUaString = periodInString.split(SPLITTER);
        return Integer.parseInt(periodInUaString[1]) - Integer.parseInt(periodInUaString[0]);
    }
}
