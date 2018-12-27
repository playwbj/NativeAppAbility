# This NativeAppAbility plugin for Apache Cordova in both android and ios platform, it provides two features : check if one app is installed; start up native app

## 1. How to install
### 1.1 install current plugin:

  cordova plugin add https://github.com/playwbj/NativeAppAbility.git --save  
### 1.2 if you wanna distinguish if the plaform is android or ios
#### 1.2.1 add below plugin
  cordova plugin add cordova-plugin-device  
#### 1.2.2 use following js to check the plaform:
  if(device.platform === 'iOS') {  
    scheme = 'twitter://';  
  }  
  else if(device.platform === 'Android') {  
    scheme = 'com.twitter.android';  
  }  
### 1.3 if need to use this plugin in ios platform, add below plugin
  cordova plugin add cordova-plugin-add-swift-support --save  

## 2. check if app is installed info:
### 2.1 android usage example:

nativeAppAbility.checkAppInstalled(
			uri,//e.g. com.tencent.qqlive  
			function(info) {  // Success callback  
        		      console.log(info.appId + ' with version '+info.version+' is installed');  
			},  
			function() {  // Error callback  
				console.log(uri + ' is not installed');  
			}  
);
    
## 3. start up a native app with uri
### 3.1 android usage example:

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
