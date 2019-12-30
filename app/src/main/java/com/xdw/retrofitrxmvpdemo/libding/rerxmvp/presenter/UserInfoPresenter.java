package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.presenter;

import android.content.Context;
import com.xdw.retrofitrxmvpdemo.libding.entity.GetListRsp;
import com.xdw.retrofitrxmvpdemo.libding.http.manager.DataManager;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.base.BasePresenter;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;

import java.util.Map;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

//该类是具体业务presenter，如需增加另一个业务，比如Order
//则可以再创建一个OrderPresenter
public class UserInfoPresenter extends BasePresenter {
    private Context mContext;
    private interfaceUtilsAll.GetListRspPv mGetListRspPv;
    private GetListRsp mGetListRsp;
    public UserInfoPresenter (Context context){
        this.mContext = context;
    }

    @Override
    public void BindPresentView(interfaceUtilsAll.PresentView presentView) {
        mGetListRspPv = (interfaceUtilsAll.GetListRspPv)presentView;
    }

    public void getUserInfo( Map<String, String> params){
        super.mCompositeSubscription.add(DataManager.getInstance(mContext).getUserInfo(params)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetListRsp>() {
                    @Override
                    public void onCompleted() {
                        if (mGetListRsp != null){
                            mGetListRspPv.onSuccess(mGetListRsp);
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                        mGetListRspPv.onError("请求失败！！");
                    }

                    @Override
                    public void onNext(GetListRsp getListRsp) {
                        mGetListRsp = getListRsp;
                    }
                })
        );
    }
}
