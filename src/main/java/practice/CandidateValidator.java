package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        List<Candidate> candidates = new ArrayList<>();
        candidates.add(candidate);
        List<String> validateCandidate = new StreamPractice().validateCandidates(candidates);
        return !validateCandidate.isEmpty();
    }
}
