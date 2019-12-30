package com.xdw.retrofitrxmvpdemo.libding.rerxmvp.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.xdw.retrofitrxmvpdemo.R;
import com.xdw.retrofitrxmvpdemo.libding.entity.GetListRsp;
import com.xdw.retrofitrxmvpdemo.libding.http.ServiceMapParams;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.interfaceUtils.interfaceUtilsAll;
import com.xdw.retrofitrxmvpdemo.libding.rerxmvp.presenter.UserInfoPresenter;

public class MainActivity extends AppCompatActivity implements interfaceUtilsAll.GetListRspPv {

    private TextView text;
    private Button button;
    private UserInfoPresenter mUserInfoPresenter =new UserInfoPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = (TextView)findViewById(R.id.text);
        button = (Button)findViewById(R.id.button);

        mUserInfoPresenter.init();
        mUserInfoPresenter.BindPresentView(mUserInfoPv);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mUserInfoPresenter.getUserInfo(ServiceMapParams.getGetListRspMapParams());
            }
        });
    }


    //通过回调来获取网络请求的数据
    private interfaceUtilsAll.GetListRspPv mUserInfoPv = new interfaceUtilsAll.GetListRspPv(){
        @Override
        public void onSuccess(GetListRsp getListRsp) {
            text.setText(getListRsp.getFemale().iterator().next().getName());
        }

        @Override
        public void onError(String result) {
            Toast.makeText(MainActivity.this,result, Toast.LENGTH_SHORT).show();
        }
    };

    //CompositeSubscription进行释放，否则会造成内存泄漏
    @Override
    protected void onDestroy(){
        super.onDestroy();
        mUserInfoPresenter.onDestroy();
    }

    @Override
    public void onError(String result) {

    }

    @Override
    public void onSuccess(GetListRsp getListRsp) {

    }
}
