package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        if (candidate == null || candidate.getPeriodsInUkr() == null) {
            return false;
        }

        String[] parts = candidate.getPeriodsInUkr().split("-");
        if (parts.length != 2) {
            return false; // albo rzuć wyjątek, jeśli dane są niepoprawne
        }

        int start = Integer.parseInt(parts[0].trim());
        int end = Integer.parseInt(parts[1].trim());

        return candidate.getAge() >= 35
                && Objects.equals(candidate.getNationality(), "Ukrainian")
                && candidate.isAllowedToVote()
                && (end - start) >= 10;
    }
}
