package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MINIMUM_CANDIDATE_ALLOWED_AGE = 35;
    private static final int MINIMUM_CANDIDATE_ALLOWED_YEARS_IN_UA = 10;
    private static final String CANDIDATE_ALLOWED_NATIONALITY = "Ukrainian";
    private static final int INDEX_YEAR_FROM = 0;
    private static final int INDEX_YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] yearsInUkraineStr = candidate.getPeriodsInUkr().split("-");

        int yeaarsInUkraine = Integer.parseInt(yearsInUkraineStr[INDEX_YEAR_TO])
                - Integer.parseInt(yearsInUkraineStr[INDEX_YEAR_FROM]);
        return candidate.getAge()
                >= MINIMUM_CANDIDATE_ALLOWED_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(CANDIDATE_ALLOWED_NATIONALITY)
                && yeaarsInUkraine >= MINIMUM_CANDIDATE_ALLOWED_YEARS_IN_UA;
    }
    //write your code here
}
