package fr.valtech.bet.domain.model.user.dto;

public class UserRankingDto {

    private Long userId;

    private Integer rank;

    private String userName;

    private Integer score;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRankingDto{");
        sb.append("userId=").append(userId);
        sb.append(", rank=").append(rank);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", score=").append(score);
        sb.append('}');
        return sb.toString();
    }
}
