package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY_UKR = "Ukrainian";
    private static final String YEARS_DELIMITER = "-";
    private static final int MIN_YEARS_CANDIDATE = 35;
    private static final int MIN_YEARS_IN_UKR = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= MIN_YEARS_CANDIDATE
                && candidate.getNationality().equals(NATIONALITY_UKR)
                && candidate.isAllowedToVote()
                && (Integer.parseInt(candidate.getPeriodsInUkr()
                .split(YEARS_DELIMITER)[1]) - Integer.parseInt(candidate.getPeriodsInUkr()
                .split(YEARS_DELIMITER)[0])) >= MIN_YEARS_IN_UKR;
    }

}
