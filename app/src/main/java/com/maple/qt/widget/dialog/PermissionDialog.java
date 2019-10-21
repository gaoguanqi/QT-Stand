package com.maple.qt.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.blankj.utilcode.util.ScreenUtils;
import com.maple.qt.R;

import java.util.List;

public class PermissionDialog extends BaseDialog {

    private Context mContext;
    public PermissionDialog(@NonNull Context context) {
        super(context);
        this.mContext = context;
        initView(context);
    }

    @Override
    public boolean hasFullScreen() {
        return false;
    }


    private void initView(Context context) {
        Window window = getWindow();
        if (window != null) {
//            window.setWindowAnimations(R.style.loading_dialog_anim);
            window.setGravity(Gravity.CENTER);
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = (int) (ScreenUtils.getScreenWidth() * 0.82);
            lp.height = (int) (ScreenUtils.getScreenHeight() * 0.42);
            window.setBackgroundDrawable(context.getResources().getDrawable(R.drawable.shape_dialog_bg));
            window.setAttributes(lp);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_permission);
        setCanceledOnTouchOutside(false);

        TextView tvTitle = this.findViewById(R.id.tv_title);
        TextView tvContent = this.findViewById(R.id.tv_content);

        Button btnConfirm = this.findViewById(R.id.btn_confirm);

        RecyclerView rv = this.findViewById(R.id.rv_permission);
        rv.setLayoutManager(new LinearLayoutManager(mContext, LinearLayoutManager.HORIZONTAL, false));
    }



    public class PermissionAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        private Context mContext;
        private List<String> mData;

        public PermissionAdapter(Context context, List<String> data) {
            this.mContext = context;
            this.mData = data;
        }

        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new PermissionViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_permission, parent, false));
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            ((PermissionViewHolder) holder).setData(mData.get(position));
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0 : mData.size();
        }
    }
    
    
    public class PermissionViewHolder extends RecyclerView.ViewHolder{

        public PermissionViewHolder(@NonNull View itemView) {
            super(itemView);
        }

        public void setData(String s) {
        }
    }
    
}
