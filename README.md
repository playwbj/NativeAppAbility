# NativeAppAbility for iOS and Android

A Plugin for Apache Cordova and by [perkins wu]

# this ability plugin provides two features now:check if one app is installed; start up native app.
## installation step:

  cordova plugin add https://github.com/playwbj/NativeAppAbility.git --save

## check if app is installed info:
### usage example:

nativeAppAbility.checkAppInstalled( </br>
			uri,//e.g. com.tencent.qqlive</br>       
			function(info) {  // Success callback</br>				
        			console.log(info.appId + ' with version '+info.version+' is installed');</br>
			},</br>
			function() {  // Error callback</br>
				console.log(uri + ' is not installed');	</br>			
			}</br>
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
