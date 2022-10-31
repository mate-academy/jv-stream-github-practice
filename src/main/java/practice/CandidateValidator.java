package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int MINIMAL_AGE = 35;
    private static final int LIVING_IN_UKRAiNE = 10;
    private static final String NATIONALITY = "Ukrainian";
    private static final String SPLIT = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split(SPLIT);
        int livingYear = Integer.parseInt(years[1]) - Integer.parseInt(years[0]);
        return candidate.getAge() >= MINIMAL_AGE & candidate.isAllowedToVote()
                & candidate.getNationality().equals(NATIONALITY) & livingYear >= LIVING_IN_UKRAiNE;
    }
}
