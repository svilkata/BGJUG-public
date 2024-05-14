package com.toshev.martin.patterns.structural.proxy;

import com.toshev.martin.patterns.structural.composite.Device;
import com.toshev.martin.patterns.structural.frontcontroller.CiscoRouter;

import java.lang.reflect.Proxy;

public class CiscoRouterDynamicProxy {
    static Device trackingDevice(Device device) {
        return (Device) Proxy.newProxyInstance(
                CiscoRouterTrackingProxy.class.getClassLoader(),
                new Class<?>[]{Device.class},
                (proxy, method, args) -> {
                    System.out.println("Method: " + method);
                    return method.invoke(device, args);
                }
        );
    }

    public static void main(String[] args) {
        Device device = new CiscoRouter();
        Device proxy = trackingDevice(device);
        proxy.stop();
        proxy.start();
    }

}
