package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private final String separator = "-";
    private final String nationality = "Ukrainian";
    private final int minimumYears = 10;
    private final int ageFrom = 35;
    private final int indexFromYear = 0;
    private final int indexTillYear = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInStrArr = candidate.getPeriodsInUkr().split(separator);
        int period = Integer.parseInt(periodInStrArr[indexTillYear])
                - Integer.parseInt(periodInStrArr[indexFromYear]);
        return candidate.getAge() >= ageFrom && candidate.isAllowedToVote()
                && candidate.getNationality().equals(nationality)
                && period >= minimumYears;
    }
}
