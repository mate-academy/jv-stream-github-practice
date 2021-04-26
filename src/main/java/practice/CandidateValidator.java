package practice;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int FROM_YEAR = 0;
    private static final int TO_YEAR = 1;

    public List<String> validateCandidates(List<Candidate> candidates) {
        return candidates.stream()
                .filter(this)
                .map(Candidate::getName)
                .sorted()
                .collect(Collectors.toList());
    }

    @Override
    public boolean test(Candidate candidate) {
        String[] year = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && (Integer.parseInt(year[TO_YEAR]) - Integer.parseInt(year[FROM_YEAR])) >= 10;
    }
}
