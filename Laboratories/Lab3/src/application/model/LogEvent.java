package application.model;

import java.util.Enumeration;

public class LogEvent {
    private String requestSessionId;
    private String requestPath;
    private Enumeration<String> parameters;
    private String ipAddress;

    public void setRequestSessionId(String requestSessionId) {
        this.requestSessionId = requestSessionId;
    }

    public void setRequestPath(String requestPath) {
        this.requestPath = requestPath;
    }

    public void setParameters(Enumeration<String> parameters) {
        this.parameters = parameters;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Override
    public String toString() {
        return "LogEvent{" +
                "requestSessionId='" + requestSessionId + '\'' +
                ", requestPath='" + requestPath + '\'' +
                ", parameters=" + parameters +
                ", ipAddress='" + ipAddress + '\'' +
                '}';
    }
}
