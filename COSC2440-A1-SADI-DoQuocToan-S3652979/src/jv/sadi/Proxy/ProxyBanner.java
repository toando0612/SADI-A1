package jv.sadi.Proxy;

public class ProxyBanner implements Banner {
    ActuaLBanner actuaLBanner;
    @Override
    public void show() {
        if (actuaLBanner == null){
            System.out.println("Loading....");
            actuaLBanner = new ActuaLBanner();
        }
        actuaLBanner.show();
    }
}
