package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final String NATIONALITY = "Ukrainian";
    private static final int MIN_AGE = 35;
    private static final int MIN_AMOUNT_OF_YEARS_LIVING_IN_UA = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] getYears = candidate.getPeriodsInUkr().split("-");
        int result = Integer.parseInt(getYears[1]) - Integer.parseInt(getYears[0]);
        return candidate.getNationality().equals(NATIONALITY) && candidate.getAge() >= MIN_AGE
                && result >= MIN_AMOUNT_OF_YEARS_LIVING_IN_UA && candidate.isAllowedToVote();
    }
}
