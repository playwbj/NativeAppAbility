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
            var sign = arguments[2];
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
    },

    initListener: function(){
        var successCallback = function(info){
             cordova.fireWindowEvent('appinstalled', info);
        };

        var errorCallback = function(info){
             console.log('error occured...');
        };
        
        cordova.addWindowEventHandler('appinstalled').onHasSubscribersChange = function(){
            cordova.exec(
                successCallback,
                errorCallback,
                "nativeAppAbility",
                "appInstalled",
                []
            );
        };
    }
};

module.exports = nativeAppAbility;

