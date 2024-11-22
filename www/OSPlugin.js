const exec = require('cordova/exec');

let OSPlugin = {
    showToast: (message, duration, successCallback, errorCallback) => {
        exec(successCallback, errorCallback, 'OSPlugin', 'showToast', [message, duration]);
    }
};

module.exports = OSPlugin;