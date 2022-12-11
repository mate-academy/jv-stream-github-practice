package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return hasVotingAge(candidate,35) && isCitizen(candidate)
                && isAllowedToVote(candidate) && hasLivedPeriod(candidate);
    }

    private boolean hasVotingAge(Candidate candidate, int age) {
        return candidate.getAge() >= age;
    }

    private boolean isAllowedToVote(Candidate candidate) {
        return candidate.isAllowedToVote();
    }

    private boolean isCitizen(Candidate candidate) {
        return candidate.getNationality().equals("Ukrainian");
    }

    private boolean hasLivedPeriod(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(years[0]);
        int endYear = Integer.parseInt(years[1]);
        return (endYear - startYear) >= 10;
    }
}
