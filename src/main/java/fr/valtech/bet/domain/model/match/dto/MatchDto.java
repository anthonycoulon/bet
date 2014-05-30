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

    private Date matchTime;

    private int quote1;

    private int quote2;

    private Integer matchLevelOrdinal;

    private String matchLevel;

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

    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    public int getQuote1() {
        return quote1;
    }

    public void setQuote1(int quote1) {
        this.quote1 = quote1;
    }

    public int getQuote2() {
        return quote2;
    }

    public void setQuote2(int quote2) {
        this.quote2 = quote2;
    }

    public Integer getMatchLevelOrdinal() {
        return matchLevelOrdinal;
    }

    public void setMatchLevelOrdinal(Integer matchLevelOrdinal) {
        this.matchLevelOrdinal = matchLevelOrdinal;
    }

    public void setMatchLevel(String matchLevel) {
        this.matchLevel = matchLevel;
    }

    public String getMatchLevel() {
        return matchLevel;
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
        sb.append(", matchTime=").append(matchTime);
        sb.append(", quote1=").append(quote1);
        sb.append(", quote2=").append(quote2);
        sb.append(", matchLevelOrdinal=").append(matchLevelOrdinal);
        sb.append(", matchLevel=").append(matchLevel);
        sb.append('}');
        return sb.toString();
    }

}
