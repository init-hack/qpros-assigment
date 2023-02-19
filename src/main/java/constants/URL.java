package constants;

public enum URL {
    homepage("https://www.demoblaze.com/", "https://www.demoblaze.com/index.html");

    private final String url;
    private final String alias;

    URL(String url, String alias) {
        this.url = url;
        this.alias = alias;
    }

    public String getUrl() {
        return url;
    }

    public String getAlias() {
        return alias;
    }

}
