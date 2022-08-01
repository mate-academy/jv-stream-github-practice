package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String[] periodSplit = candidate.getPeriodsInUkr().split("-");
        int years = Integer.parseInt(periodSplit[1])
                - Integer.parseInt(periodSplit[0]);
        String requiredNationality = "Ukrainian";
        int minYearsToLive = 10;
        int minAge = 35;

        return candidate.getAge() >= minAge
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals(requiredNationality)
                && years > minYearsToLive;
    }
}
