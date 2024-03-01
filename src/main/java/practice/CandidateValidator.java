package practice;

import java.time.Year;
import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {

    @Override
    public boolean test(Candidate candidate) {
        if (!candidate.getPeriodsInUkr().contains("-")) {
            throw new RuntimeException("Incorrect periods");
        }
        String periods = candidate.getPeriodsInUkr();
        int firstYear = Integer.parseInt(periods.substring(0, periods.indexOf("-")));
        int lastYear = Integer.parseInt(periods.substring(periods.indexOf("-") + 1));
        if (firstYear < 1900 || lastYear > Year.now().getValue() || firstYear > lastYear) {
            throw new RuntimeException("Incorrect periods");
        }
        return candidate.isAllowedToVote() && candidate.getAge() >= 35
                && candidate.getNationality().equals("Ukrainian")
                && lastYear - firstYear >= 10;
    }
}
