package practice;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final String NATIONALITY = "Ukrainian";
    private static final int AGE_FROM = 35;

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
        return listCandidateYears.get(1) - listCandidateYears.get(0) >= 10;
    }
}
