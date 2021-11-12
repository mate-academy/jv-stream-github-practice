package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian")
            && Integer.parseInt(candidate.getPeriodsInUkr().replaceAll("\\d+-", ""))
            - Integer.parseInt(candidate.getPeriodsInUkr().replaceAll("-\\d+", "")) >= 10
            && candidate.getAge() >= 35 && candidate.isAllowedToVote();
    }
}
