package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    public static final int MIN_AGE = 35;
    public static final int MINIMUM_YEARS_IN_UKR = 10;
    public static final int YEAR_START_POSITION = 0;
    public static final int YEAR_END_POSITION = 1;
    public static final String YEAR_SEPARATOR = "-";
    public static final String REQUIRED_NATIONALITY = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        List<Integer> yearsIssuing = Arrays.stream(candidate.getPeriodsInUkr()
                        .split(YEAR_SEPARATOR))
                    .map(Integer::parseInt)
                    .toList();
        if (yearsIssuing.size() < 2) {
            throw new IndexOutOfBoundsException("The start or final year of issuing missing.");
        }
        return candidate.getAge() >= MIN_AGE && candidate.isAllowedToVote()
               && candidate.getNationality().equals(REQUIRED_NATIONALITY)
               && yearsIssuing.get(YEAR_END_POSITION) - yearsIssuing.get(YEAR_START_POSITION)
                >= MINIMUM_YEARS_IN_UKR;
    }
}
