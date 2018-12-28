package com.dvt.elementui.biz.vo.auth;

import com.dvt.elementui.biz.model.SysPermission;
import com.dvt.elementui.biz.model.SysUser;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;
import org.apache.commons.lang.StringUtils;
import org.assertj.core.util.Sets;

import java.util.List;
import java.util.Set;

public class RolePermissionVO {

    private Integer roleId;
    private String roleName;
    private List<SysUser> users;
    private List<MenuVO> menus;

    public RolePermissionVO() {
    }

    public RolePermissionVO(Integer roleId, String roleName, String userIds, String nicknames, String menuCodes, String menuNames, String permissionIds, String permissionNames ) {
        this.roleId = roleId;
        this.roleName = roleName;

        if(this.users==null){
            this.users = Lists.newArrayList();
        }

        if(this.menus==null){
            this.menus = Lists.newArrayList();
        }

        if(StringUtils.isNotBlank(userIds)){
            String[] userIdArr = userIds.split(",");
            String[] nicknameArr = nicknames.split(",");

            Set<Integer> noReaptedUserIdsSet = Sets.newHashSet();


            for (int i = 0; i < userIdArr.length; i++) {
                Integer userId = Integer.parseInt(userIdArr[i]);
                if(noReaptedUserIdsSet.contains(userId)){
                    continue;
                }else{
                    SysUser user = new SysUser();
                    user.setId(userId);
                    user.setNickname(nicknameArr[i]);
                    this.users.add(user);
                    noReaptedUserIdsSet.add(userId);
                }
            }
        }



        String[] menuCodeArr = menuCodes.split(",");
        String[] menuNameArr = menuNames.split(",");
        String[] permissionIdArr = permissionIds.split(",");
        String[] permissionNameArr = permissionNames.split(",");

        Set<String> noReaptedMenuCodesSet = Sets.newHashSet();
        Set<Integer> noReaptedPermissionIdsSet = Sets.newHashSet();

        for(int i=0; i<menuCodeArr.length; i++){
            if(noReaptedMenuCodesSet.contains(menuCodeArr[i])){

                String menuCode = menuCodeArr[i];
                MenuVO menuVO = (MenuVO) CollectionUtils.find(this.menus, new Predicate() {
                    @Override
                    public boolean evaluate(Object o) {
                        MenuVO _o = (MenuVO) o;
                        return _o.getMenuCode().equals(menuCode);
                    }
                });
                Integer permissionId = Integer.parseInt(permissionIdArr[i]);

                if(CollectionUtils.collect(menuVO.getPermissions(),  new Transformer() {
                    public Object transform(Object arg0) {
                        SysPermission p = (SysPermission) arg0;
                        return p.getId();
                    }
                }).contains(permissionId)){
                    continue;
                } else{
                    SysPermission p = new SysPermission();
                    p.setId(permissionId);
                    p.setPermissionName(permissionNameArr[i]);
                    menuVO.getPermissions().add(p);
                }
            }else{
                MenuVO menuVO = new MenuVO();
                menuVO.setMenuCode(menuCodeArr[i]);
                menuVO.setMenuName(menuNameArr[i]);

                noReaptedPermissionIdsSet = Sets.newHashSet();
                Integer permissionId = Integer.parseInt(permissionIdArr[i]);
                List<SysPermission> permissions = Lists.newArrayList();
                SysPermission p = new SysPermission();
                p.setId(permissionId);
                p.setPermissionName(permissionNameArr[i]);
                permissions.add(p);
                menuVO.setPermissions(permissions);
                this.menus.add(menuVO);

                noReaptedPermissionIdsSet.add(permissionId);
                noReaptedMenuCodesSet.add(menuCodeArr[i]);
            }
        }
    }

    public RolePermissionVO(Integer roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public Integer getRoleId() {
        return this.roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return this.roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public List<SysUser> getUsers() {
        return this.users;
    }

    public void setUsers(List<SysUser> users) {
        this.users = users;
    }

    public List<MenuVO> getMenus() {
        return this.menus;
    }

    public void setMenus(List<MenuVO> menus) {
        this.menus = menus;
    }
}
