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
    
    startupNativeApp: function() {
        if(arguments.length == 3){
            var urlScheme = arguments[0];
            var successCallback = arguments[1];
            var errorCallback = arguments[2];

            cordova.exec(
                        successCallback,
                        errorCallback,
                        "nativeAppAbility",
                        "startupNativeApp",
                        [urlScheme]
                    );
        }else if (arguments.length == 5){
            var urlScheme = arguments[0];
            var userId = arguments[1];
            var sign = arguments[2]
            var successCallback = arguments[3];
            var errorCallback = arguments[4];

            cordova.exec(
                        successCallback,
                        errorCallback,
                        "nativeAppAbility",
                        "startupNativeApp",
                        [urlScheme, userId, sign]
                    );
        }
    }
};

module.exports = nativeAppAbility;

});
