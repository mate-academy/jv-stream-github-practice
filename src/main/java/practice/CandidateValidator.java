package practice;

import model.Candidate;

import java.util.function.Predicate;

public class CandidateValidator implements Predicate<Candidate> {
    private final static int INDEX_OF_YEAR_FROM = 0;
    private final static int INDEX_OF_YEAR_TO = 1;

    @Override
    public boolean test(Candidate candidate) {
        String[] periodInUkr = candidate.getPeriodsInUkr().split("-");
        int yearFrom = Integer.valueOf(periodInUkr[INDEX_OF_YEAR_FROM]);
        int yearTo = Integer.valueOf(periodInUkr[INDEX_OF_YEAR_TO]);

        if (candidate.getAge() >= 35 && candidate.getNationality().equals("Ukrainian")
                && candidate.isAllowedToVote() && yearTo - yearFrom >= 10) {
            return true;
        }
        return false;
    }


    //write your code here
}
