package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    @Override
    public boolean test(Candidate candidate) {
        return candidate.getAge() >= 35
                && candidate.isAllowedToVote()
                && candidate.getNationality().equals("Ukrainian")
                && yearsInUkraine(candidate.getPeriodsInUkr()) >= 10;
    }

    private int yearsInUkraine(String periodsInUkr) {
        String[] years = periodsInUkr.split("-");
        int yearFrom = Integer.parseInt(years[0]);
        int yearTo = Integer.parseInt(years[1]);
        return yearTo - yearFrom;
    }
}
