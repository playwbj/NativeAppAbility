//
//  NativeAppAbility.swift
//  MyTestApp1
//
//  Created by wingconn on 2018/12/27.
//  Copyright © 2018 wingconn. All rights reserved.
//

import Foundation

@objc(NativeAppAbility) class NativeAppAbility: CDVPlugin {
    
    //check if app is installed
    func checkAppInstalled(_ command: CDVInvokedUrlCommand){
        var pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: true);
        let uriArg = command.argument(at: 0) as! String;
        let url = URL.init(string: uriArg);
        
        let isExsited = UIApplication.shared.canOpenURL(url!);
        if isExsited {
            return self.commandDelegate.send(pluginResult, callbackId: command.callbackId);
        }else{
            pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: false);
            return self.commandDelegate.send(pluginResult, callbackId: command.callbackId);
        }
    }
    
    //startup the native app    
    func startupNativeApp(_ command: CDVInvokedUrlCommand){
        var pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: true);
        let uriArg = command.argument(at: 0) as! String;
        let url = URL.init(string: uriArg);
        
        let isOpened = UIApplication.shared.openURL(url!);
        if isOpened {
            return self.commandDelegate.send(pluginResult, callbackId: command.callbackId);
        }else{
            pluginResult = CDVPluginResult(status: CDVCommandStatus_OK, messageAs: false);
            return self.commandDelegate.send(pluginResult, callbackId: command.callbackId);
        }
    }
}
