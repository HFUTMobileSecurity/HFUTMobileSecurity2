package com.innovation.android.detectdriod;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.ListView;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
//建立视图与适配器的联系
public class ShowPermission extends Activity {

    private String PkgName;
    private ListView listview = null;
    private PackageManager pm;
    private List<HashMap<String, Object>> mlistPermissoinInfo;
    private BrowsePermissoinInfoAdapter browsePermissoinAdapter = null;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.browse_permission_list);
        listview = (ListView) findViewById(R.id.permissionlist);
        PkgName = getIntent().getStringExtra("PackageName");
        //需要获取权限的函数，返回类型为List<Map<String,Object>>
        try {
            mlistPermissoinInfo = getPermission(PkgName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        browsePermissoinAdapter = new BrowsePermissoinInfoAdapter(this, mlistPermissoinInfo);
        listview.setAdapter(browsePermissoinAdapter);
    }


    //获取权限
    private List<HashMap<String, Object>> getPermission(String appName) throws PackageManager.NameNotFoundException {
        pm = this.getPackageManager();
        List<HashMap<String, Object>> listData = new ArrayList<HashMap<String, Object>>();
            //获得应用程序权限
            String[] info = pm.getPackageInfo(appName, pm.GET_PERMISSIONS).requestedPermissions;
            int i = 0;
            if (info != null) {
                for (int j = 0; j < info.length; j++) {
                    HashMap<String, Object> permissionMap = new HashMap<String, Object>();
                    if (!permissionMap.containsValue(info[j])) {
                        i++;
                        permissionMap.put("authority", info[j]);
                        //permissionMap.put("select item", false);
                        listData.add(permissionMap);
                    }
                }
            }
        return listData;
    }
}


