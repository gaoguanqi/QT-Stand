package com.maple.qt.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.blankj.utilcode.util.ActivityUtils;
import com.irozon.sneaker.Sneaker;
import com.maple.qt.R;
import com.maple.qt.utils.UIUtils;
import com.maple.qt.utils.eventbus.Event;
import com.maple.qt.utils.eventbus.EventBusUtils;
import com.maple.qt.widget.loading.LoadingDialog;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.Unbinder;

public abstract class BaseActivity extends AppCompatActivity implements IView{

    protected Unbinder mUnbinder;
    private LoadingDialog mLoadingDialog;

    protected abstract int getLayoutResId();
    protected abstract void initData(Bundle savedInstanceState);


    protected void setContentView(){
        setContentView(getLayoutResId());
        mUnbinder = ButterKnife.bind(this);
    }


    protected boolean hasUsedEventBus(){
        return false;
    }



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        if(hasUsedEventBus()){
            EventBusUtils.register(this);
        }
        initData(savedInstanceState);

    }


    /**
     * 可以在子类中重写onStickyEventBusCome（）
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventBusReceive(Event event) {
        if (event != null) {
            onEventBusDispense(event);
        }
    }

    /**
     * 可以在子类中重写onStickyEventBusCome（）
     *
     * @param event
     */
    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    public void onStickyEventBusReceive(Event event) {
        if (event != null) {
            onStickyEventBusDispense(event);
        }
    }


    protected void onEventBusDispense(Event event){ }
    protected void onStickyEventBusDispense(Event event){ }





    protected void showTopMessage(String s){
        if(!UIUtils.isEmpty(s)){
            Sneaker sneaker = Sneaker.with(this);
            View view = LayoutInflater.from(this).inflate(R.layout.sneaker_view,  sneaker.getView(), false);
            TextView tvMessage = view.findViewById(R.id.tv_message);
            if(tvMessage != null) tvMessage.setText(s);
            sneaker.sneakCustom(view);
        }
    }




    protected void showLoading() {
        if(mLoadingDialog == null){
            mLoadingDialog = new LoadingDialog(this);
        }
        if(!mLoadingDialog.isShowing()){
            mLoadingDialog.show();
        }
    }

    protected void hideLoading() {
        if(mLoadingDialog != null && mLoadingDialog.isShowing()){
            mLoadingDialog.dismiss();
        }
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(hasUsedEventBus()){
            EventBusUtils.unregister(this);
        }

        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY){
            mUnbinder.unbind();
            this.mUnbinder = null;
        }
    }
}
