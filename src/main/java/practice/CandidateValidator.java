package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MINIMAL_AGE = 35;
    private static final int MINIMAL_YEARS_IN_UA = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final int START_LIVING_YEAR_INDEX = 0;
    private static final int END__LIVING_YEAR_INDEX = 1;

    @Override
    public boolean test(Candidate candidate) {
        List<Integer> years = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .toList();
        return candidate.getAge() >= MINIMAL_AGE
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && (years.get(END__LIVING_YEAR_INDEX)
                - years.get(START_LIVING_YEAR_INDEX)) >= MINIMAL_YEARS_IN_UA;
    }
}
