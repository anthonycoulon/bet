package fr.valtech.bet.domain.model.match.dto;

public class QuotesDto {

    private Long matchId;

    private Integer quote1;

    private Integer quote2;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Integer getQuote1() {
        return quote1;
    }

    public void setQuote1(Integer quote1) {
        this.quote1 = quote1;
    }

    public Integer getQuote2() {
        return quote2;
    }

    public void setQuote2(Integer quote2) {
        this.quote2 = quote2;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuotesDto{");
        sb.append("matchId=").append(matchId);
        sb.append(", quote1=").append(quote1);
        sb.append(", quote2=").append(quote2);
        sb.append('}');
        return sb.toString();
    }
}
