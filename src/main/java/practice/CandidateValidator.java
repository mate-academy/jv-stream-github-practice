package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int MIN_AGE = 35;
    public static final String REQUIRED_NATIONALITY = "Ukrainian";
    public static final int MIN_PERIOD_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(REQUIRED_NATIONALITY)
                && timeLivedInUkraine(candidate) >= MIN_PERIOD_IN_UKRAINE;
    }

    private static int timeLivedInUkraine(Candidate candidate) {
        String[] periodDate = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(periodDate[1]) - Integer.parseInt(periodDate[0]);
    }
    //write your code here
}
