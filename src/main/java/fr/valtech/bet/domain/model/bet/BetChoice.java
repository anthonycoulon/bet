package fr.valtech.bet.domain.model.bet;

public enum BetChoice {

    V1("VICTORY1"), N("DRAW"), V2("VICTORY2");

    private String label;

    BetChoice(String label){
        this.label = label;
    }

}
