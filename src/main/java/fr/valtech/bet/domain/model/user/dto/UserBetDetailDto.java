package fr.valtech.bet.domain.model.user.dto;

import java.util.List;

public class UserBetDetailDto {

    private Integer rank;

    private String userName;

    private Integer score;

    private List<UserBetDto> userBets;

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public List<UserBetDto> getUserBets() {
        return userBets;
    }

    public void setUserBets(List<UserBetDto> userBets) {
        this.userBets = userBets;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserBetDetailDto{");
        sb.append("rank=").append(rank);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", score=").append(score);
        sb.append(", userBets=").append(userBets);
        sb.append('}');
        return sb.toString();
    }
}
