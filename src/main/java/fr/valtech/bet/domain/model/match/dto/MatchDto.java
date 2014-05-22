package fr.valtech.bet.domain.model.match.dto;

public class MatchDto {

    private String opponent1;

    private String opponent2;

    private Integer score1;

    private Integer score2;

    private Integer bet1;

    private Integer bet2;

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

    public Integer getScore1() {
        return score1;
    }

    public void setScore1(Integer score1) {
        this.score1 = score1;
    }

    public Integer getScore2() {
        return score2;
    }

    public void setScore2(Integer score2) {
        this.score2 = score2;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("MatchDto{");
        sb.append("opponent1='").append(opponent1).append('\'');
        sb.append(", opponent2='").append(opponent2).append('\'');
        sb.append(", score1=").append(score1);
        sb.append(", score2=").append(score2);
        sb.append(", bet1=").append(bet1);
        sb.append(", bet2=").append(bet2);
        sb.append('}');
        return sb.toString();
    }
}
