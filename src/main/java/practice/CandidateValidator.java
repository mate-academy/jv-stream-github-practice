package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_AGE = 35;
    private static final int FIST_ELEMENT = 0;
    private static final int SECOND_ELEMENT = 1;
    private static final int TEN_YEARS = 10;
    private static final String NATIONALITY_UKR = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKR)
                && (Integer.valueOf(candidate.getPeriodsInUkr().split("-")[SECOND_ELEMENT])
                - Integer.valueOf(candidate.getPeriodsInUkr().split("-")[FIST_ELEMENT]))
                >= TEN_YEARS;
    }
}
