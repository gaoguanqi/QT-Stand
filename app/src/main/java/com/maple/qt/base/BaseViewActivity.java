package com.maple.qt.base;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;

import butterknife.ButterKnife;

public abstract class BaseViewActivity<DB extends ViewDataBinding, VM extends BaseViewModel> extends BaseActivity {

    private DB binding;

    protected abstract int getBindingVariable();

    protected abstract DB getViewModel();

    @Override
    protected void setContentView() {
        binding = DataBindingUtil.setContentView(this, getLayoutResId());
        mUnbinder = ButterKnife.bind(this);
        binding.executePendingBindings(); //当数据改变时，调用executePendingBindings方法立即改变。
        binding.setVariable(getBindingVariable(), getViewModel());
    }




}
