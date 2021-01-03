import constants from "../constants";

export default {
  saveToken(tokenData) {
    return Promise.resolve(
      this.store(constants.STORAGE_KEY.TOKEN_DATA, JSON.stringify(tokenData))
    );
  },

  getTokenData() {
    let tokenDataStr = this.get(constants.STORAGE_KEY.TOKEN_DATA);
    return tokenDataStr ? JSON.parse(tokenDataStr) : null;
  },

  saveOtpToken(otpToken) {
    console.log("otpToken: " + otpToken);
    return Promise.resolve(
      this.store(constants.STORAGE_KEY.OTP_TOKEN, otpToken)
    );
  },

  removeToken() {
    this.remove(constants.STORAGE_KEY.TOKEN_DATA);
    this.remove(constants.STORAGE_KEY.OTP_TOKEN);
    return Promise.resolve(null);
  },

  checkIsAuthenticated() {
    let tokenDataStr = this.get(constants.STORAGE_KEY.TOKEN_DATA);
    // let otpToken = this.getOtpToken();
    // return Promise.resolve(tokenDataStr && otpToken ? JSON.parse(tokenDataStr) : null);
    return Promise.resolve(tokenDataStr ? JSON.parse(tokenDataStr) : null);
  },

  getIdToken() {
    let tokenData = this.getTokenData();
    return tokenData ? tokenData["id_token"] : null;
  },

  getOtpToken() {
    return this.get(constants.STORAGE_KEY.OTP_TOKEN);
  },

  storeLastURL(lastURL) {
    localStorage.setItem("lastURL", lastURL);
  },

  getLastURL() {
    return localStorage.getItem("lastURL");
  },

  removeLastURL() {
    return localStorage.removeItem("lastURL");
  },

  store(key, value) {
    value == null || value === undefined ? localStorage.removeItem(key) : localStorage.setItem(key, value);
  },

  get(key) {
    return localStorage.getItem(key);
  },

  remove(key) {
    return localStorage.removeItem(key);
  },

  storeStateBeforeLogin(to) {
    let stateURLBeforeLogin = {
      URL: to.path,
      ID: ("id" + new Date().getTime()).toString(),
      QUERY: to.query,
      PARAMS: to.params,
      ROUTER_NAME: to.name
    };
    this.store(
      constants.STATE_URL_BEFORE_LOGIN,
      JSON.stringify(stateURLBeforeLogin)
    );
    // console.log(JSON.stringify(stateURLBeforeLogin));
    return Promise.resolve(null);
  }
};
