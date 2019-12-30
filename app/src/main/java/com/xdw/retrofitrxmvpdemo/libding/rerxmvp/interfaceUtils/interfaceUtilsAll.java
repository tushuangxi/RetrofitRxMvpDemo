package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.interfaceUtils;

import com.xdw.retrofitrxmvpdemo.libding.entity.GetListRsp;

public class interfaceUtilsAll {

    public interface PresentView {

        void onError(String result);
    }




    public interface GetListRspPv extends PresentView {

        void onSuccess(GetListRsp getListRsp);
    }

    public interface Presenter {
        //Presenter初始化
        void init();
        //销毁
        void onDestroy();
        //绑定视图
        void BindPresentView(interfaceUtilsAll.PresentView presentView);
    }

}
