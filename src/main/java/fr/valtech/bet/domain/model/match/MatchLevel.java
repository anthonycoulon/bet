package fr.valtech.bet.domain.model.match;

public enum MatchLevel {
    A("Group A"), B("Group B"), C("Group C"), D("Group D"), E("Group E"), F("Group F"), G("Group G"), H("Group H"), eighth("Eighth Final"), quarter(
            "Quarter Final"), semi("Semi Final"), final2("Third Place"), final1("Final");

    private final String label;

    MatchLevel(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
