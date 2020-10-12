package simplegroupsapp.error;

public enum ServerErrorCode {
    GROUP_DUPLICATE("Номер группы уже существует: %s");

    private String message;

    ServerErrorCode(String message) {
        this.message = message;
    }

    public String getErrorString() {
        return message;
    }
}
