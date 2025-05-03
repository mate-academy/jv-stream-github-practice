package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final int YEARS_IN_UKR = 10;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] periodsInUkr = candidate.getPeriodsInUkr().split("-");
        int yearsInUkr = Integer.parseInt(periodsInUkr[1]) - Integer.parseInt(periodsInUkr[0]);
        return candidate.isAllowedToVote()
                && candidate.getAge() >= AGE
                && NATIONALITY.equals(candidate.getNationality())
                && yearsInUkr >= YEARS_IN_UKR;
    }
    //write your code here
}
