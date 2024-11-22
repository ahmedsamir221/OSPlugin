const exec = require("cordova/exec");

let OSPlugin = {
  showToast: (message, duration, successCallback, errorCallback) => {
    exec(successCallback, errorCallback, "OSPlugin", "showToast", [
      message,
      duration,
    ]);
  },
  addInt: (num1, num2, successCallback, errorCallback) => {
    exec(successCallback, errorCallback, "OSPlugin", "addInt", [num1, num2]);
  },
  showMap: (successCallback, errorCallback) => {
    exec(successCallback, errorCallback, "OSPlugin", "showMap", []);
  },
};

module.exports = OSPlugin;
