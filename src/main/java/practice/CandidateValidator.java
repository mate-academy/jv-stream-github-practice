package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate != null
                && candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && livedInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }

    private int livedInUkraine(String periodsInUrk) {
        return Integer.parseInt(periodsInUrk.substring(5, 9))
                - Integer.parseInt(periodsInUrk.substring(0, 4));
    }
}
