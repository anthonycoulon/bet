package fr.valtech.bet.domain.model.user.dto;

public class UserBetDto {

    private String bet;

    private String oponent1;

    private String oponent2;

    private String flag1;

    private String flag2;

    public String getBet() {
        return bet;
    }

    public void setBet(String bet) {
        this.bet = bet;
    }

    public String getOponent1() {
        return oponent1;
    }

    public void setOponent1(String oponent1) {
        this.oponent1 = oponent1;
    }

    public String getOponent2() {
        return oponent2;
    }

    public void setOponent2(String oponent2) {
        this.oponent2 = oponent2;
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserBetDto{");
        sb.append("bet='").append(bet).append('\'');
        sb.append(", oponent1='").append(oponent1).append('\'');
        sb.append(", oponent2='").append(oponent2).append('\'');
        sb.append(", flag1='").append(flag1).append('\'');
        sb.append(", flag2='").append(flag2).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
