package fr.valtech.bet.domain.model.match.dto;

import java.util.Date;
import org.apache.commons.lang3.StringUtils;

public class MatchDto {

    private Long matchId;

    private String opponent1;

    private String opponent2;

    private String score;

    private String bet;

    private Integer bet1;

    private Integer bet2;

    private Date matchDate;

    private Date matchTime;

    private int odds1;

    private int odds2;

    private Integer matchLevelOrdinal;

    private String matchLevel;

    private String flag1;

    private String flag2;

    private String matchLevelShort;

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

    public int getOdds1() {
        return odds1;
    }

    public void setOdds1(int odds1) {
        this.odds1 = odds1;
    }

    public int getOdds2() {
        return odds2;
    }

    public void setOdds2(int odds2) {
        this.odds2 = odds2;
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

    public String getFlag1() {
        return flag1;
    }

    public void setFlag1(String flag1) {
        this.flag1 = flag1;
    }

    public String getFlag2() {
        return flag2;
    }

    public void setFlag2(String flag2) {
        this.flag2 = flag2;
    }

    public void setMatchLevelShort(String matchLevelShort) {
        this.matchLevelShort = matchLevelShort;
    }

    public String getMatchLevelShort() {
        return matchLevelShort;
    }

    public int getWinner() {
        if (StringUtils.isBlank(score)) {
            return 0;
        }
        Integer s1 = Integer.valueOf(score.split("-", 2)[0]);
        Integer s2 = Integer.valueOf(score.split("-", 2)[1]);

        if (s1 > s2) {
            return 1;
        } else if (s2 > s1) {
            return 2;
        }
        return 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MatchDto{");
        sb.append(", matchId=").append(matchId);
        sb.append(", opponent1='").append(opponent1).append('\'');
        sb.append(", opponent2='").append(opponent2).append('\'');
        sb.append(", score='").append(score).append('\'');
        sb.append(", bet='").append(bet).append('\'');
        sb.append(", bet1=").append(bet1);
        sb.append(", bet2=").append(bet2);
        sb.append(", matchDate=").append(matchDate);
        sb.append(", matchTime=").append(matchTime);
        sb.append(", odds1=").append(odds1);
        sb.append(", odds2=").append(odds2);
        sb.append(", matchLevelOrdinal=").append(matchLevelOrdinal);
        sb.append(", matchLevel='").append(matchLevel).append('\'');
        sb.append(", flag1='").append(flag1).append('\'');
        sb.append(", flag2='").append(flag2).append('\'');
        sb.append(", matchLevelShort='").append(matchLevelShort).append('\'');
        sb.append('}');
        return sb.toString();
    }

}
