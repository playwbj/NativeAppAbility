var nativeAppAbility = {
    
    check: function(urlScheme, successCallback, errorCallback) {
        cordova.exec(
            successCallback,
            errorCallback,
            "NativeAppAbility",
            "checkAvailability",
            [urlScheme]
        );
    },
    
    checkBool: function(urlScheme, callback) {
        cordova.exec(
            function(success) { callback(success); },
            function(error) { callback(error); },
            "AppAvailability",
            "checkAvailability",
            [urlScheme]
        );
    }
    
};

module.exports = nativeAppAbility;