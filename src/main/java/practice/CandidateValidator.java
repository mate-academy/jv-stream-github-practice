package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE_QUALIFICATION = 35;
    private static final int MIN_AGES_IN_UKRAINE = 10;

    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= AGE_QUALIFICATION
                && candidate.getNationality().equals("Ukrainian")
                && getAgesInUkraine(candidate) >= MIN_AGES_IN_UKRAINE
                && candidate.isAllowedToVote();
    }

    private int getAgesInUkraine(Candidate candidate) {
        String[] ages = candidate.getPeriodsInUkr().split("-");
        return Integer.parseInt(ages[1]) - Integer.parseInt(ages[0]);
    }
}
