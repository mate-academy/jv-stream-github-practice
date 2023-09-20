package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        int age = candidate.getAge();
        boolean isUkrainian = "Ukrainian".equals(candidate.getNationality());
        boolean hasVotingRights = candidate.isAllowedToVote();
        String[] periods = candidate.getPeriodsInUkr().split("-");
        int startYear = Integer.parseInt(periods[0]);
        int endYear = Integer.parseInt(periods[1]);
        boolean hasLivedInUkraineFor10Years = (endYear - startYear + 1) >= 10;

        return age >= 35 && isUkrainian && hasVotingRights && hasLivedInUkraineFor10Years;
    }
}






