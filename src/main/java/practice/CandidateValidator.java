package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    private static final int MIN_TERM_IN_UKR = 35;
    private static final int START_YEAR_INDEX = 0;
    private static final int END_YEAR_INDEX = 1;
    private static final int TEN_YEARS = 10;
    private static final String NATIONALITY_UKR = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_TERM_IN_UKR
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKR)
                && (Integer.valueOf(candidate.getPeriodsInUkr().split("-")[END_YEAR_INDEX])
                - Integer.valueOf(candidate.getPeriodsInUkr().split("-")[START_YEAR_INDEX]))
                >= TEN_YEARS;
    }
}
