package practice;

import java.util.function.Predicate;
import model.Candidate;

public class CandidateValidator implements Predicate<Candidate> {
    private int startYearLivingInCountry;
    private int finishYearLivingInCountry;
    private String[] yearsLivingInCountry;
    private int periodLivingInCountry;

    @Override
    public boolean test(Candidate candidate) {
        yearsLivingInCountry = candidate.getPeriodsInUkr().split("-");
        startYearLivingInCountry = Integer.parseInt(yearsLivingInCountry[0]);
        finishYearLivingInCountry = Integer.parseInt(yearsLivingInCountry[1]);
        periodLivingInCountry = finishYearLivingInCountry - startYearLivingInCountry;
        return candidate.getNationality().equals("Ukrainian") && candidate.isAllowedToVote()
                && periodLivingInCountry >= 10 && candidate.getAge() >= 35;
    }
}
