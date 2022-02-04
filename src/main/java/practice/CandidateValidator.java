package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY_UKR = "Ukrainian";
    private static final String YEARS_DELIMITER = "-";
    private static final int MIN_YEARS_IN_UKR = 10;
    private static final int CANDIDATE_MIN_AGE = 35;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(YEARS_DELIMITER);
        int yearsInUkr = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return candidate.getAge() >= CANDIDATE_MIN_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_UKR)
                && yearsInUkr >= MIN_YEARS_IN_UKR;
    }
}
