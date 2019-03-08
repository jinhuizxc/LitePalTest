package com.jh.dbtest;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.jh.dbtest.db.DbHelper;
import com.jh.dbtest.model.Singer;
import com.jh.dbtest.model.Student;
import com.jh.dbtest.model.TopBean;
import com.jh.dbtest.model.TopItemBean;
import com.jh.dbtest.view.LitePalRvAdapter;

import org.litepal.LitePal;
import org.litepal.tablemanager.Connector;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * 使用LitePal存储list集合数据
 * https://blog.csdn.net/cjm2484836553/article/details/78279457
 * <p>
 * 异常：
 * java.net.UnknownServiceException: CLEARTEXT communication not supported:
 * [ConnectionSpec(cipherSuites=[TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, TLS_DHE_RSA_WITH_AES_128_CBC_SHA, TLS_DHE_RSA_WITH_AES_256_CBC_SHA, TLS_RSA_WITH_AES_128_GCM_SHA256, TLS_RSA_WITH_AES_128_CBC_SHA, TLS_RSA_WITH_AES_256_CBC_SHA, TLS_RSA_WITH_3DES_EDE_CBC_SHA], tlsVersions=[TLS_1_2, TLS_1_1, TLS_1_0], supportsTlsExtensions=true), ConnectionSpec(cipherSuites=[TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, TLS_DHE_RSA_WITH_AES_128_CBC_SHA, TLS_DHE_RSA_WITH_AES_256_CBC_SHA, TLS_RSA_WITH_AES_128_GCM_SHA256, TLS_RSA_WITH_AES_128_CBC_SHA, TLS_RSA_WITH_AES_256_CBC_SHA, TLS_RSA_WITH_3DES_EDE_CBC_SHA], tlsVersions=[TLS_1_0], supportsTlsExtensions=true)]
 * 解决方法
 * https://blog.csdn.net/qq_2300688967/article/details/81114201
 */
public class MainActivity extends AppCompatActivity implements TopDataController.GetTopDataListener {


    private static final String TAG = "MainActivity";

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    private SQLiteDatabase db;

    private TopDataController topDataController;

    private List<TopItemBean> topListContainer;

    private LitePalRvAdapter litePalRvAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        topDataController = new TopDataController();
        //设置获取数据成功后的监听
        topDataController.setGetTopDataListener(this);
        topListContainer = new ArrayList<>();

        // 生成表
        db = Connector.getDatabase();

        initView();

        initData();

        test();

    }

    private void test() {
        Student student = new Student();
        student.setName("tom");
        int num = (int) (Math.random() * 100);
        student.setAge(num);
        student.setMale(true);
        DbHelper.getInstance().save(student);

        Singer singer = new Singer();
        singer.setName("lily");
        singer.setAge((int) (Math.random() * 100));
        singer.setMale(false);
        DbHelper.getInstance().save(singer);

    }

    private void initData() {
        String testUrl = "http://v.juhe.cn/toutiao/index?type=top&key=ec9b00bad2c53b5d0c9df4e8bf185a4f";
        topDataController.getTopNetData(testUrl);

    }

    private void initView() {
        //初始化recyclerView相关的操作
        litePalRvAdapter = new LitePalRvAdapter();
        //在setAdapter前设置分割线
        recyclerView.addItemDecoration(new MyRvDeviderDecorationd(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(litePalRvAdapter);
    }

    /**
     * 联网获取数据成功的回调
     *
     * @param topBean
     */
    @Override
    public void getTopDataSuccess(TopBean topBean) {
        Log.d(TAG, "返回数据: " + topBean);
        List<TopItemBean> topList = topBean.getResult().getData();
        topListContainer.clear();
        topListContainer.addAll(topList);

        // 联网成功的数据保存到数据库中
        LitePal.deleteAll(TopItemBean.class);
        LitePal.saveAll(topListContainer);

        Log.e("TAG", "count=" + topListContainer.size());

        //刷新adapter的数据
        litePalRvAdapter.updateTopData(topListContainer);
    }

    /**
     * 联网获取数据失败的回调
     *
     * @param e
     */
    @Override
    public void getTopDataError(Exception e) {
        Log.d(TAG, "返回数据: " + e.toString());
        // 联网获取数据失败,则去数据库中取集合数据
        List<TopItemBean> topListFromDb = LitePal.findAll(TopItemBean.class);
        //重新装配数据并刷新
        topListContainer.clear();
        topListContainer.addAll(topListFromDb);
        litePalRvAdapter.updateTopData(topListContainer);
        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
    }
}
