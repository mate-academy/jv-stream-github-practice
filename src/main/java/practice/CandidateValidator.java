package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MINIMUM_CANDIDATE_ALLOWED_AGE = 35;
    private static final int MINIMUM_CANDIDATE_ALLOWED_YEARS_IN_UA = 10;
    private  static final String CANDIDATE_ALLOWED_NATIONALITY = "Ukrainian";
    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraineStr = candidate.getPeriodsInUkr().split("-");
        int yeaarsInUkraine = Integer.parseInt(yearsInUkraineStr[1]) - Integer.parseInt(yearsInUkraineStr[0]);
        return candidate.getAge() >= MINIMUM_CANDIDATE_ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_ALLOWED_NATIONALITY)
                && yeaarsInUkraine >= MINIMUM_CANDIDATE_ALLOWED_YEARS_IN_UA;
    }
    //write your code here
}
