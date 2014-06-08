package fr.valtech.bet.domain.model.match;

public enum MatchLevel {
    A("Group A", "Group A"), B("Group B", "Group B"), C("Group C", "Group C"), D("Group D", "Group D"), E("Group E", "Group E"), F(
            "Group F", "Group H"), G("Group G", "Group G"), H("Group H", "Group H"), eighth("Eighth Final", "1/8 Final"), quarter(
            "Quarter Final", "1/4 Final"), semi("Semi Final", "1/2 Final"), final2("Third Place", "Final 2"), final1("Final", "Final");

    private final String label;

    private final String shortLabel;

    MatchLevel(String label, String shortLabel) {
        this.label = label;
        this.shortLabel = shortLabel;
    }

    public String getLabel() {
        return label;
    }

    public String getShortLabel() {
        return shortLabel;
    }
}
