package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MIN_YEAR = 35;
    private static final int FIRST_INDEX_YEAR = 0;
    private static final int LAST_INDEX_YEAR = 1;
    private static final int MIN_YEARS = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= MIN_YEAR && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), "Ukrainian")
                && Integer.parseInt(years[LAST_INDEX_YEAR])
                - Integer.parseInt(years[FIRST_INDEX_YEAR]) >= MIN_YEARS;
    }
}
