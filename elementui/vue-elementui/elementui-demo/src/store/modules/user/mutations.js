export default {
  SET_USER: (state, userInfo) => {
    state.nickname = userInfo.nickname;
    state.userId = userInfo.userId;
    state.role = userInfo.roleName;
    state.menus = userInfo.menuList;
    state.permissions = userInfo.permissionList;
  },
  RESET_USER: (state) => {
    state.nickname = "";
    state.userId = "";
    state.role = '';
    state.menus = [];
    state.permissions = [];
  }
}
