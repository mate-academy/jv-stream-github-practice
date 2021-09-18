package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int SUITABLE_AGE = 35;
    private static final int YEARS_IN_UKRAINE_OK = 10;
    private static final int YEARS_IN_UKRAINE_START = 0;
    private static final int YEARS_IN_UKRAINE_END = 1;
    private static final String NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= SUITABLE_AGE
            && NATIONALITY.equals(candidate.getNationality())
            && candidate.isAllowedToVote()
            && Integer.parseInt(candidate.getPeriodsInUkr().split("-")[YEARS_IN_UKRAINE_END])
            - Integer.parseInt(candidate.getPeriodsInUkr().split("-")[YEARS_IN_UKRAINE_START])
                >= YEARS_IN_UKRAINE_OK;
    }
}
