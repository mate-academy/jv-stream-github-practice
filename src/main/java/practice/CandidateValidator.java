package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final int indexSinceYear = 0;
    private final int indexByYear = 1;
    private final int minPeriodsInUkraine = 10;
    private final int minAge = 35;
    private final String ukrainianNationality = "Ukrainian";

    @Override
    public boolean test(Candidate candidate) {
        String[] split = candidate.getPeriodsInUkr().split("-");
        return candidate.getAge() >= minAge
                && candidate.getNationality().equals(ukrainianNationality)
                && (Integer.parseInt(split[indexByYear])
                - Integer.parseInt(split[indexSinceYear])) >= minPeriodsInUkraine
                && candidate.isAllowedToVote();
    }
}
