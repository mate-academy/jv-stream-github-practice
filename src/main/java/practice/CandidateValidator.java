package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35 && candidate.isAllowedToVote()
                && checkDate(candidate) && candidate.getNationality().equals("Ukrainian");
    }

    private boolean checkDate(Candidate candidate) {
        String[] arrayData = candidate.getPeriodsInUkr().split("-");
        int result = Integer.parseInt(String.valueOf(arrayData[1]))
                - Integer.parseInt(String.valueOf(arrayData[0]));
        return result >= 10;
    }
}
