package application;

import java.util.Date;

public class MappingValue {
    private final String value;
    private final Date timestamp;

    public MappingValue(String value) {
        this.value = value;
        this.timestamp = new Date();
    }

    @Override
    public String toString() {
        return "MappingValue{" +
                "value='" + value + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }

    public String getValue() {
        return value;
    }

    public Date getTimestamp() {
        return new Date(timestamp.getTime());
    }
}
