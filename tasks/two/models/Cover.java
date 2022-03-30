package by.epam.tr.tasks.two.models;

public enum Cover {

    SOFT(1),
    HARD(2);

    private int code;

    Cover(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Cover getByCode(int code) {
        for (Cover cover : Cover.values()) {
            if (cover.getCode() == code) {
                return cover;
            }
        }
        return null;
    }
}
