package com.zuker.xposedtest;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XMain implements IXposedHookLoadPackage {


    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam loadPackageParam) throws Throwable {
        if( !loadPackageParam.packageName.toString().contains("com.zuker.xposedtest") ) {
            return;
        }
        XposedBridge.log("OKay " + loadPackageParam.packageName.toString() );
        XposedBridge.log("OKay " + loadPackageParam.appInfo.toString() );
        XposedBridge.log("OKay " + loadPackageParam.processName.toString() );
        if(  loadPackageParam.classLoader == null ) {
            XposedBridge.log( "classLoader is null" );
        } else {
            XposedBridge.log( "classLoader not is null" );
            XposedBridge.log( "classLoader is " + loadPackageParam.classLoader.toString() );
        }
        Class clazz=loadPackageParam.classLoader.loadClass("com.zuker.xposedtest.MainActivity");
        XposedHelpers.findAndHookMethod(clazz, "hook", new XC_MethodHook() {
            @Override
            protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                super.beforeHookedMethod(param);
            }

            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                param.setResult("你已经被劫持了");
            }
        });
    }
}
