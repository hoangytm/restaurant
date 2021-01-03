import axios from "axios";
import qs from "qs";
import constants from "../utils/constants";
import authenService from "./authenService";
import {
  EventBus
} from "../event-bus.js";
import utils from "./utils";

export default {

  getUploadAttachmentHeaders() {
    let header = {};
    let idToken = authenService.getIdToken();
    idToken && (header["Authorization"] = "Bearer " + idToken);
    // let userDeptRoleId = authenService.get(
    //   constants.STORAGE_KEY.USER_DEPT_ROLE_ID
    // );
    // userDeptRoleId &&
    // (header[constants.HTTP_HEADER_KEY.USER_DEPT_ROLE_ID] = userDeptRoleId);
    return header;
  },

  initConfig(config) {
    !config && (config = {});
    !config.paramsSerializer &&
      (config.paramsSerializer = function (params) {
        return qs.stringify(params, {
          arrayFormat: "repeat"
        });
      });

    !config.baseURL && (config.baseURL = constants.BASE_SERVICE_URL);

    !config.headers && (config.headers = {});

    !config.timeout &&
      (config.timeout = constants.AXIOS_REQUEST_TIMEOUT * 1000);

    let header = config.headers;

    !header["Content-Type"] && (header["Content-Type"] = "application/json");

    let idToken = authenService.getIdToken();
    idToken &&
      (header[constants.HTTP_HEADER_KEY.AUTH_HEADER_STRING] =
        "Bearer " + idToken);

    // let otpToken = authenService.getOtpToken();
    idToken &&
      (header[constants.HTTP_HEADER_KEY.OTP_AUTH_HEADER_STRING] = otpToken);

    let roleCode = authenService.get(constants.STORAGE_KEY.ROLE_CODE);
    roleCode && (header[constants.HTTP_HEADER_KEY.ROLE_CODE] = roleCode);

    let deptCode = authenService.get(constants.STORAGE_KEY.DEPT_CODE);
    deptCode && (header[constants.HTTP_HEADER_KEY.DEPT_CODE] = deptCode);

    let userDeptRoleId = authenService.get(
      constants.STORAGE_KEY.USER_DEPT_ROLE_ID
    );
    userDeptRoleId &&
      (header[constants.HTTP_HEADER_KEY.USER_DEPT_ROLE_ID] = userDeptRoleId);

    return config;
  },

  post(url, data, config) {
    config = this.initConfig(config);
    return axios.post(url, data, config).catch(error => {
      this.handleGlobalError(error);
      throw error;
    });
  },

  put(url, data, config) {
    config = this.initConfig(config);
    return axios.put(url, data, config).catch(error => {
      this.handleGlobalError(error);
      throw error;
    });
  },

  get(url, config) {
    config = this.initConfig(config);
    return axios.get(url, config).catch(error => {
      this.handleGlobalError(error);
      throw error;
    });
  },

  delete(url, config) {
    config = this.initConfig(config);
    return axios.delete(url, config).catch(error => {
      this.handleGlobalError(error);
      throw error;
    });
  },

  postFile(url, data, config) {
    (!config) && (config = {});
    (!config.responseType) && (config.responseType = "blob");
    return this.post(url, data, config);
  },

  getFlie(url, config) {
    (!config) && (config = {});
    (!config.responseType) && (config.responseType = "blob");
    return this.get(url, config);
  },

  handleGlobalError(error) {
    if (utils.isErrorResponseMatch(error, constants.HTTP_STATUS.UNAUTHORIZED)) {
        console.log('error happen', error)
      EventBus.$emit(constants.EVENT_BUS.CATCH_ERROR_RESPONSE, {
        error: error
      });
    }
  }
};
