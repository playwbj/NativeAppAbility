cordova.define("cordova-plugin-nativeappability.nativeAppAbility", function(require, exports, module) {
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

    startupAppWithParams: function(urlScheme, userId, sign,successCallback,errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            "nativeAppAbility",
            "startupAppWithParams",
            [urlScheme, userId, sign]
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

});
