package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    private static final int MIN_CANDIDATE_AGE = 35;
    private static final String CANDIDATE_NATIONALITY = "Ukrainian";
    private static final int MIN_YEARS_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        String[] candidatesNew = candidate.getPeriodsInUkr().split("-");
        int[] candidatesInt = new int[candidatesNew.length];
        for (int i = 0; i < candidatesNew.length; i++) {
            candidatesInt[i] = Integer.parseInt(candidatesNew[i]);
        }
        boolean isCandidateFit = candidatesInt[1] - candidatesInt[0] >= MIN_YEARS_IN_UKRAINE
                && candidate.getAge() >= MIN_CANDIDATE_AGE
                && candidate.getNationality().equals(CANDIDATE_NATIONALITY)
                && candidate.isAllowedToVote();
        return isCandidateFit;
    }
}
