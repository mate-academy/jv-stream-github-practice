package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        String requiredNationality = "Ukrainian";
        int minAgeRequired = 35;
        int minPeriodInUkraine = 10;
        return candidate.isAllowedToVote()
                && candidate.getAge() > minAgeRequired
                && candidate.getNationality().equals(requiredNationality)
                && periodInUkraine(candidate.getPeriodsInUkr()) > minPeriodInUkraine;
    }

    ;
    private Integer periodInUkraine(String period) {
        int indexOfLifeSince = 0;
        int indexOfLifeTo = 1;
        String[] stringAfterSplit = period.split("-");
        Integer lifeSince = Integer.parseInt(stringAfterSplit[indexOfLifeSince]);
        Integer lifeTo = Integer.parseInt(stringAfterSplit[indexOfLifeTo]);
        return lifeTo - lifeSince;
    }
}
