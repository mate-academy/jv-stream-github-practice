package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEARS_IN_COUNTRY = 10;
    private static final int MIN_AGE_CANDIDATE = 35;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLITTER = "-";

    @Override
    public boolean test(Candidate candidate) {
        int positionSplitter = candidate.getPeriodsInUkr().indexOf(SPLITTER);
        return candidate.getAge() >= MIN_AGE_CANDIDATE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(positionSplitter + 1))
                - Integer.parseInt(candidate.getPeriodsInUkr()
                .substring(0, positionSplitter))) > MIN_YEARS_IN_COUNTRY;
    }
}
