package fr.valtech.bet.domain.model.match.dto;

public class OddsDto {

    private Long matchId;

    private Integer odds1;

    private Integer odds2;

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Integer getOdds1() {
        return odds1;
    }

    public void setOdds1(Integer odds1) {
        this.odds1 = odds1;
    }

    public Integer getOdds2() {
        return odds2;
    }

    public void setOdds2(Integer odds2) {
        this.odds2 = odds2;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("QuotesDto{");
        sb.append("matchId=").append(matchId);
        sb.append(", odds1=").append(odds1);
        sb.append(", odds2=").append(odds2);
        sb.append('}');
        return sb.toString();
    }
}
