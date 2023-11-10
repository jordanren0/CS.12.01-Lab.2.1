public class Phone extends ElectronicItem{
    private String networkType;
    private int screenSize;

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
    }

    public int getScreenSize() {
        return screenSize;
    }

    public void setScreenSize(int screenSize) {
        this.screenSize = screenSize;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Phone{" +
                "networkType='" + networkType + '\'' +
                ", screenSize=" + screenSize +
                '}';
    }
}
