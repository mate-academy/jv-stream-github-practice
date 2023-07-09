package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    public static final int MIN_AGE_FOR_PRESIDENT_POSITION = 35;
    public static final int MIN_LIVING_YEARS_FOR_PRESIDENT_POSITION = 10;
    public static final String PRESIDENT_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE_FOR_PRESIDENT_POSITION
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(PRESIDENT_NATIONALITY)
                && getLivingYearsInUkraine(candidate) >= MIN_LIVING_YEARS_FOR_PRESIDENT_POSITION;
    }

    private int getLivingYearsInUkraine(Candidate candidate) {
        String[] stringYears = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(stringYears[1]) - Integer.parseInt(stringYears[0]);
    }
}
