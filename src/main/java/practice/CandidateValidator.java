package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final String DASH = "-";
    public static final int FIRST_YEAR = 0;
    public static final int SECOND_YEAR = 1;
    public static final int MIN_PER = 10;
    public static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split(DASH);
        int firstYear = Integer.parseInt(split[FIRST_YEAR]);
        int secondYear = Integer.parseInt(split[SECOND_YEAR]);
        int sum = secondYear - firstYear;
        if ((candidate.getAge() < MIN_AGE || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals("Ukrainian") || sum < MIN_PER)) {
            return false;
        }
        return true;
    }
    //write your code here
}
