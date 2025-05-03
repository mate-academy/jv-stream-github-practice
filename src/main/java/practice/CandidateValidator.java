package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private static final int AGE = 35;
    private static final int MIN_YEARS = 10;
    private static final String COUNTRY = "Ukrainian";
    private static final String SPLITERATOR = "-";

    @Override
    public boolean test(Candidate candidate) {
        String[] time = candidate.getPeriodsInUkr().split(SPLITERATOR);
        int first = Integer.parseInt(time[0]);
        int second = Integer.parseInt((time[1]));
        int result = second - first;
        return candidate.getAge() >= AGE
                 && candidate.isAllowedToVote()
                 && candidate.getNationality().equals(COUNTRY)
                 && result >= MIN_YEARS;
    }
}
