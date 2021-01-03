import httpService from "../services/httpService";

export default {
  insert(form) {
    return httpService.post("user", form);
  },

  update(form) {
    return httpService.put("user/",form);
  },

  findById(id) {
    return httpService.get("user/findUserById/" + id);
  },

  changeStatus(id) {
    return httpService.put(`user/${id}/changeStatus`);
  },
  changeDefault(id) {
    return httpService.put(`user/${id}/changeDefault`);
  }
};
