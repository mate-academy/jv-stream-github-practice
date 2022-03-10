package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    //write your code here
    @Override
    public boolean test(Candidate candidate) {
        boolean mostRequirements = candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian");
        if (!mostRequirements) {
            return false;
        }
        String[] years = candidate.getPeriodsInUkr().split("-");
        int fromYear = Integer.parseInt(years[0]);
        int toYear = Integer.parseInt(years[1]);
        return toYear - fromYear >= 10;
    }
}
