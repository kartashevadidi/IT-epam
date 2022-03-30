package by.epam.tr.tasks.three.models;

public enum AirplaneType {

    BOEING(1),
    AIRBUS(2);

    private int code;

    AirplaneType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static AirplaneType getByCode(int code) {
        for (AirplaneType type : AirplaneType.values()) {
            if (type.getCode() == code) {
                return type;
            }
        }
        return null;
    }
}
