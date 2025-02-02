package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int FIRST_YEAR = 0;
    public static final int SECOND_YEAR = 1;
    public static final int MIN_PER = 10;
    public static final int MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        int FirstYear = Integer.parseInt(split[FIRST_YEAR]);
        int SecondYear = Integer.parseInt(split[SECOND_YEAR]);
        int Sum = SecondYear - FirstYear;
        if ((candidate.getAge() < MIN_AGE || !candidate.isAllowedToVote()
                || !candidate.getNationality().equals("Ukrainian") || Sum < MIN_PER)) {
            return false;
        }
        return true;
    }
    //write your code here
}
