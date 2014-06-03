package fr.valtech.bet.domain.model.match.dto;

import java.util.Date;

public class AdminMatchDto {

    private Long id;

    private String opponent1;

    private String opponent2;

    private String score;

    private Date matchTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Date getMatchTime() {
        return matchTime;
    }

    public void setMatchTime(Date matchTime) {
        this.matchTime = matchTime;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AdminMatchDto{");
        sb.append("id=").append(id);
        sb.append(", opponent1='").append(opponent1).append('\'');
        sb.append(", opponent2='").append(opponent2).append('\'');
        sb.append(", score='").append(score).append('\'');
        sb.append(", matchTime=").append(matchTime);
        sb.append('}');
        return sb.toString();
    }
}
