package com.innovation.android.detectdriod;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Switch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
//建立布局和适配器的联系
public class BrowsePermissoinInfoAdapter extends BaseAdapter {
    
    private List<HashMap<String,Object>> mlistPermissionInfo = null;

    LayoutInflater infater = null;

    public BrowsePermissoinInfoAdapter(Context context, List<HashMap<String,Object>> AppPermissions) {
        infater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mlistPermissionInfo = AppPermissions ;
    }
    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return mlistPermissionInfo.size();
    }
    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return mlistPermissionInfo.get(position);
    }
    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public View getView(int position, View convertview, ViewGroup arg2) {
        View view = null;
        ViewHolder holder = null;
        if (convertview == null || convertview.getTag() == null) {
            view = infater.inflate(R.layout.browse_permission_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }
        else{
            view = convertview ;
            holder = (ViewHolder) convertview.getTag() ;
        }
        HashMap<String,Object> PermissionInfos = (HashMap<String, Object>) getItem(position);
        //将获取的权限在textview中显示出来
        holder.PermissionText.setText((String)PermissionInfos.get("authority"));
        //如何将权限与开关关联起来？？？
        //holder.PermissionSwitch
        return view;
    }

    class ViewHolder {
        TextView PermissionText;
        Switch PermissionSwitch;

        public ViewHolder(View view) {
            this.PermissionText = (TextView) view.findViewById(R.id.PermissionText);
            this.PermissionSwitch = (Switch)view.findViewById(R.id.PermissionSwitch);
        }
    }

}
