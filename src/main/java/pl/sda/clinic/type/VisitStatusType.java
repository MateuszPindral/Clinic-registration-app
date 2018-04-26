package pl.sda.clinic.type;

public enum VisitStatusType {

    NON_EXISTENT("Brak"),
    AVAILABLE("Wolna"),
    UNAVAILABLE("Zajeta");

    private String name;

    VisitStatusType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
