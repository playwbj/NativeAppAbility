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

## 2. check if app is installed info
 if you wanna use this function in IOS device, please add the uri scheme white list to your package，refer to http://note.youdao.com/noteshare?id=ed4883e4bc52c3b6485e06f5723ae3e2
 
### 2.1 usage example:

nativeAppAbility.checkAppInstalled(
			uri,//e.g. android: "com.tencent.qqlive" ,  ios: "tenvideo://"  
			function(info) {  // Success callback  
        		      console.log(info.appId + ' with version '+info.version+' is installed');  
			},  
			function() {  // Error callback  
				console.log(uri + ' is not installed');  
			}  
);
    
## 3. start up a native app with uri or with uri, userid and sign, 
## <span style="color:red">Notes: if the length of the whole parameters are not 3 or 5, nothing will be done</span>
### 3.1 usage example, to start up app with no parameters
nativeAppAbility.startupNativeApp(  
			uri,//e.g. android: "com.tencent.qqlive" ,  ios: "tenvideo://"  
			function(info) {  // Success callback  
				console.log(uri + ' is opened successfully');  
			},  
			function() {  // Error callback  
				console.log(uri + ' is opened unsuccessfully');  
			}  
		);  
	}  
### 3.2 usage example， to start up app with userId and sign parameters  
## 3.2.1 in android platform use following :  
nativeAppAbility.startupNativeApp(  
			uri,//e.g. android: "com.tencent.qqlive"  
			userId,//e.g. "1234"  
			sign,e.g. "233asdfer123"  
			function(info) {  // Success callback  
				console.log(uri + ' is opened successfully');  
			},  
			function() {  // Error callback  
				console.log(uri + ' is opened unsuccessfully');  
			}  
		);  
	}  
## 3.2.2 in ios platform use following :  
nativeAppAbility.startupNativeApp(  
			uri,//e.g. "tenvideo://mycenter?userid=123&sign=234"  
			function(info) {  // Success callback  
				console.log(uri + ' is opened successfully');  
			},  
			function() {  // Error callback  
				console.log(uri + ' is opened unsuccessfully');  
			}  
		);  
	}  
### 3.2 usage example， to start up the browser to load a url
nativeAppAbility.startupNativeApp(  
			uri,//e.g. "http://my.wingconn.com?a=xxx"  
			function(info) {  // Success callback  
				console.log(uri + ' is opened successfully');  
			},  
			function() {  // Error callback  
				console.log(uri + ' is opened unsuccessfully');  
			}  
		);  
	}  
