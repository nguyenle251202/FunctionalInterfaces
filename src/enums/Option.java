package enums;

public enum Option {
    EXIT(0),
    HIGHESTGROSSING(1),
    HIGHESTVALUE(2),
    SEGMENTORDER(3),
    TOPSPENDER(4),
    TOTALREVENUECUSTOMER(5),
    TOTALREVENUEMONTH(6);

    private final int code;

    Option(int code) {
        this.code = code;
    }

    // Tìm enum theo code
    public static Option fromCode(int code) {
        for (Option opt : Option.values()) {
            if (opt.code == code) return opt;
        }
        return null;
    }

    public int getCode() {
        return code;
    }
}

