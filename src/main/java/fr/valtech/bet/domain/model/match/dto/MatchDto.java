package fr.valtech.bet.domain.model.match.dto;

import java.util.Date;

public class MatchDto {

    private Long betId;

    private Long matchId;

    private String opponent1;

    private String opponent2;

    private String score;

    private String bet;

    private Integer bet1;

    private Integer bet2;

    private Date matchDate;

    public Long getBetId() {
        return betId;
    }

    public void setBetId(Long betId) {
        this.betId = betId;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getOpponent1() {
        return opponent1;
    }

    public void setOpponent1(String opponent1) {
        this.opponent1 = opponent1;
    }

    public String getOpponent2() {
        return opponent2;
    }

    public void setOpponent2(String opponent2) {
        this.opponent2 = opponent2;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public Integer getBet1() {
        return bet1;
    }

    public void setBet1(Integer bet1) {
        this.bet1 = bet1;
    }

    public Integer getBet2() {
        return bet2;
    }

    public void setBet2(Integer bet2) {
        this.bet2 = bet2;
    }

    public Date getMatchDate() {
        return matchDate;
    }

    public void setMatchDate(Date matchDate) {
        this.matchDate = matchDate;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MatchDto{");
        sb.append("betId=").append(betId);
        sb.append(", matchId=").append(matchId);
        sb.append(", opponent1='").append(opponent1).append('\'');
        sb.append(", opponent2='").append(opponent2).append('\'');
        sb.append(", score='").append(score).append('\'');
        sb.append(", bet='").append(bet).append('\'');
        sb.append(", bet1=").append(bet1);
        sb.append(", bet2=").append(bet2);
        sb.append(", matchDate=").append(matchDate);
        sb.append('}');
        return sb.toString();
    }
}
