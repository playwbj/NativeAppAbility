var nativeAppAbility = {    
    checkAppInstalled: function(urlScheme, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            "NativeAppAbility",
            "checkAppInstalled",
            [urlScheme]
        );
    },
    
    startupNativeApp: function(urlScheme, successCallback,errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            "NativeAppAbility",
            "startupNativeApp",
            [urlScheme]
        );
    }
    
};

module.exports = nativeAppAbility;