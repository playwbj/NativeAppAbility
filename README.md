# NativeAppAbility for iOS and Android

A Plugin for Apache Cordova and by [perkins wu]

# this ability plugin provides two features now:check if one app is installed; start up native app.
## installation current plugin:

  cordova plugin add https://github.com/playwbj/NativeAppAbility.git --save  
## if you wanna distinguish if the plaform is android or ios, install the plugin cordova-plugin-device:
  cordova plugin add cordova-plugin-device  
## and use following js to check the plaform:
  if(device.platform === 'iOS') {  
    scheme = 'twitter://';  
  }  
  else if(device.platform === 'Android') {  
    scheme = 'com.twitter.android';  
  }  
  
  

## check if app is installed info:
### usage example:

nativeAppAbility.checkAppInstalled(
			uri,//e.g. com.tencent.qqlive  
			function(info) {  // Success callback  
        		      console.log(info.appId + ' with version '+info.version+' is installed');  
			},  
			function() {  // Error callback  
				console.log(uri + ' is not installed');  
			}  
);
    
## start up a native app with uri
### usage example:

nativeAppAbility.startupNativeApp(  
			uri,//e.g. com.tencent.qqlive  
			function(info) {  // Success callback  
				console.log(uri + ' is opened successfully');  
			},  
			function() {  // Error callback  
				console.log(uri + ' is opened unsuccessfully');  
			}  
		);  
	}  

# todo: IOS support
