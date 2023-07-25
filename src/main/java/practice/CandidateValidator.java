package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    public static final int POSITION_OF_LAST_YEAR_IN_UKRAINE = 1;
    public static final int POSITION_OF_FIRST_YEAR_IN_UKRAINE = 0;
    public static final int MINIMAL_ALLOWED_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MINIMAL_ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && Integer.parseInt(years[POSITION_OF_LAST_YEAR_IN_UKRAINE])
                - Integer.parseInt(years[POSITION_OF_FIRST_YEAR_IN_UKRAINE]) >= 10;
    }
    //write your code here
}
