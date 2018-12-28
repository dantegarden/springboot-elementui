package com.dvt.elementui.biz.vo.auth;

import com.dvt.elementui.biz.model.SysPermission;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import org.assertj.core.util.Sets;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class PermissionVO {

    private List<Map<String,Object>> permissions;
    private String menuName;

    public PermissionVO(String menuName, String ids, String menuCodes, String permissionCodes, String permissionNames, String requiredPerms) {
        this.menuName = menuName;
        String[] idArr = ids.split(",");
        String[] menuCodesArr = menuCodes.split(",");
        String[] permissionCodeArr = permissionCodes.split(",");
        String[] permissionNameArr = permissionNames.split(",");
        String[] requiredPermArr = requiredPerms.split(",");


        Set<Integer> noReaptedUserIdsSet = Sets.newHashSet();
        if(this.permissions==null){
            this.permissions = Lists.newArrayList();
        }

        for(int i=0; i<idArr.length ;i++){
            this.permissions.add(ImmutableMap.of(
                    "id", Integer.parseInt(idArr[i]),
                    "menuCode", menuCodesArr[i],
                    "permissionCode", permissionCodeArr[i],
                    "permissionName", permissionNameArr[i],
                    "requiredPerm", Boolean.valueOf(requiredPermArr[i])));
        }
    }

    public PermissionVO() {
    }

    public String getMenuName() {
        return this.menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public List<Map<String, Object>> getPermissions() {
        return this.permissions;
    }

    public void setPermissions(List<Map<String, Object>> permissions) {
        this.permissions = permissions;
    }
}
