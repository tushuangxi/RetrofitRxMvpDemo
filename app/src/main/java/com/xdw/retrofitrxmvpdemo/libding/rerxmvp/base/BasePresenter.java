package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.base;

import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import rx.subscriptions.CompositeSubscription;

public class BasePresenter implements interfaceUtilsAll.Presenter {

    protected CompositeSubscription mCompositeSubscription;
    @Override
    public void init() {

        mCompositeSubscription = new CompositeSubscription();
    }

    @Override
    public void onDestroy() {
        //释放CompositeSubscription，否则会造成内存泄漏
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }

    @Override
    public void BindPresentView(interfaceUtilsAll.PresentView presentView) {
        //与具体视图进行绑定，留个子类进行扩展
    }
}
