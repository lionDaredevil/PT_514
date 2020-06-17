package constants;

public enum BrowserNames {
    CHROME("chrome"),
    FIREFOX("firexox"),
    SAFARI("safari");

    private String browserName;
    BrowserNames(String browserName){
        this.browserName = browserName;
    }

    public String getBrowserName() {
        return browserName;
    }
}
