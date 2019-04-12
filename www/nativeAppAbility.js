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
    },

    closeNativeApp: function(successCallback,errorCallback) {
      cordova.exec(
          successCallback,
          errorCallback,
          "nativeAppAbility",
          "closeNativeApp");
    }
};

module.exports = nativeAppAbility;
