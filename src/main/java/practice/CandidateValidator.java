package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] years = candidate.getPeriodsInUkr().split("-");
        boolean isValidAge = candidate.getAge() >= 35;
        boolean isValidVoteAllow = candidate.isAllowedToVote();
        boolean isValidNationality = candidate.getNationality().equals("Ukrainian");
        boolean isValidYearsPeriod = Integer.parseInt(years[1]) - Integer.parseInt(years[0]) >= 10;
        return isValidAge && isValidNationality && isValidYearsPeriod && isValidVoteAllow;
    }

    //write your code here
}
