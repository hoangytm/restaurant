let host = window.location.hostname;
// console.log.log(host)
export default {
  SSO_CLIENT_ID: process.env.VUE_APP_SSO_CLIENT_ID,
  SSO_LOGIN_CALLBACK: process.env.VUE_APP_SSO_LOGIN_CALLBACK,
  SSO_LOGOUT_CALLBACK: process.env.VUE_APP_SSO_LOGOUT_CALLBACK,
  SSO_URL: process.env.VUE_APP_SSO_URL,
  SSO_URL_LOGOUT: process.env.VUE_APP_SSO_URL_LOGOUT,
  STATE_URL_BEFORE_LOGIN: "stateURLBeforeLogin",
  AXIOS_REQUEST_TIMEOUT: process.env.AXIOS_REQUEST_TIMEOUT,
  BASE_SERVICE_URL: 'http://localhost:9999/user',
  SIGN_TOKEN_BASE_SERVICE_URL: "http://localhost:6704/api/",



  STORAGE_KEY: {
    ROLE_CODE: "roleCode",
    DEPT_CODE: "deptCoe",
    USER_DEPT_ROLE_ID: "userDeptRoleId",
    CHO_TIEP_NHAN_DOC_ID: "choTiepNhan.docId",
    OTP_TOKEN: "otpToken",
    TOKEN_DATA: "tokenData"
  },

  HTTP_HEADER_KEY: {
    ROLE_CODE: "RoleCode",
    DEPT_CODE: "DeptCode",
    USER_DEPT_ROLE_ID: "UserDeptRoleId",
    OTP_AUTH_HEADER_STRING: "OtpJwt",
    AUTH_HEADER_STRING: "Authorization",
    X_TENANT_CODE: "TenantCode"
  },
  HTTP_STATUS: {
    FORBIDDEN: 403,
    UNAUTHORIZED: 401,
    BAD_REQUEST: 400
  },
 
};
