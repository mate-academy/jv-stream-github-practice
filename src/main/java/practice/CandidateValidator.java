package practice;

import java.util.Objects;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] strArr = candidate.getPeriodsInUkr().split("-");
        int firstDate = Integer.parseInt(strArr[0]);
        int secondDate = Integer.parseInt(strArr[1]);
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && Objects.equals(candidate.getNationality(), "Ukrainian")
                && secondDate - firstDate >= 10;
    }
}
