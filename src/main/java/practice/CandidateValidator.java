package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] candidatesNew = candidate.getPeriodsInUkr().split("-");
        int[] candidatesInt = new int[candidatesNew.length];
        for (int i = 0; i < candidatesNew.length; i++) {
            candidatesInt[i] = Integer.parseInt(candidatesNew[i]);
        }
        boolean isCandidateFit = candidatesInt[1] - candidatesInt[0] >= 10
                && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote();
        return isCandidateFit;
    }
}
