package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_MUST_BE_OLDER = 35;
    private static final String NATIONALITY_MUST_BE = "Ukrainian";
    private static final int YEARS_IN_UKRAINE = 10;
    private static final String SPLIT_SYMBOL = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLIT_SYMBOL);
        return candidate.getAge() >= AGE_MUST_BE_OLDER
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY_MUST_BE)
                && Integer.parseInt(years[1]) - Integer.parseInt(years[0]) >= YEARS_IN_UKRAINE;
    }
}
