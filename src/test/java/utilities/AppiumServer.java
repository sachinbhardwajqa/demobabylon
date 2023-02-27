package utilities;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;

public class AppiumServer {
    private static AppiumDriverLocalService service;

    public static void main(String[] args) throws InterruptedException {
        start("android");
        Thread.sleep(4000);
        stop();
    }

    public static void start(String platform) {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("0.0.0.0");
        builder.usingPort(4723);
        builder.withArgument(io.appium.java_client.service.local.flags.GeneralServerFlag.SESSION_OVERRIDE);
        builder.withArgument(io.appium.java_client.service.local.flags.GeneralServerFlag.LOG_LEVEL, "error");
        builder.withAppiumJS(new File("/usr/local/lib/node_modules/appium/build/lib/main.js"));


        service = AppiumDriverLocalService.buildService(builder);
        service.start();
    }

    public static void stop() {
        service.stop();
    }
}
