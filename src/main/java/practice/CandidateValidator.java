package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int ACCEPTED_AGE = 35;
    private static final int ACCEPTED_NUMBER_OF_YEARS_IN_UKRAINE = 10;
    private static final int INDEX_OF_LAST_YEAR_IN_UKRAINE = 1;
    private static final int INDEX_OF_FIRST_YEAR_IN_UKRAINE = 0;
    private static final String ACCEPTED_NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= ACCEPTED_AGE
                && candidate.isAllowedToVote()
                && yearsLivedInUkraineOf(candidate) >= ACCEPTED_NUMBER_OF_YEARS_IN_UKRAINE
                && candidate.getNationality().equals(ACCEPTED_NATIONALITY);
    }

    private int yearsLivedInUkraineOf(Candidate candidate) {
        String[] yearsLivedInUkraine = candidate.getPeriodsInUkr().split(SPLITTER);
        return Integer.parseInt(yearsLivedInUkraine[INDEX_OF_LAST_YEAR_IN_UKRAINE])
                - Integer.parseInt(yearsLivedInUkraine[INDEX_OF_FIRST_YEAR_IN_UKRAINE]);
    }
}
