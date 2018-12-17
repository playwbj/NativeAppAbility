var nativeAppAbility = {    
    checkAppInstalled: function(urlScheme, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            "nativeAppAbility",
            "checkAppInstalled",
            [urlScheme]
        );
    },
    
    startupNativeApp: function(urlScheme, successCallback,errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            "nativeAppAbility",
            "startupNativeApp",
            [urlScheme]
        );
    }
    
};

module.exports = nativeAppAbility;