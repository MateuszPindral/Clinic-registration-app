package pl.sda.clinic.type;

import java.util.Arrays;

public enum DocSpecType {

    CARDIOLOGIST("kardiolog"),
    DERMATOLOGIST("dermatolog"),
    DENTIST("dentysta"),
    HEMATOLOGIST("hematolog");

    private String name;

    DocSpecType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static DocSpecType findByName(String name){
        DocSpecType[] values = DocSpecType.values();
        return Arrays.asList(values).stream()
                .filter(t -> t.getName().equals(name))
                .findFirst().get();
    }

}
