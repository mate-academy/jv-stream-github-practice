package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int SUITABLE_CANDIDATE_AGE = 35;
    private static final int YEARS_IN_COUNTRY = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String REGEX_FOR_PERIODS = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= SUITABLE_CANDIDATE_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodCalculator(candidate) >= YEARS_IN_COUNTRY;
    }

    private int periodCalculator(Candidate candidate) {
        String[] splited = candidate.getPeriodsInUkr().split(REGEX_FOR_PERIODS);
        return Integer.valueOf(splited[1]) - Integer.valueOf(splited[0]);
    }
    //write your code here
}
