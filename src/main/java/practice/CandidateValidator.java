package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int AGE_FROM = 35;
    private static final int YEAR_FROM = 1;
    private static final int YEAR_TO = 0;
    private static final int YEARS_VALIDATE_CANDIDATE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_FROM && candidate.isAllowedToVote()
                && candidate.getNationality().equals(NATIONALITY)
                && periodMoreThan10Years(candidate);
    }

    private boolean periodMoreThan10Years(Candidate candidate) {
        List<Integer> listCandidateYears = Arrays.stream(candidate.getPeriodsInUkr().split("-"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return listCandidateYears.get(YEAR_FROM) - listCandidateYears.get(YEAR_TO)
                >= YEARS_VALIDATE_CANDIDATE;
    }
}
