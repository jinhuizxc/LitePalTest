package com.jh.litepaltest.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.jh.litepaltest.R;

/**
 * LitePal的使用
 * https://www.jianshu.com/p/9d0d00b69fe8
 *
 * Android 数据库框架LitePal使用详解
 * https://blog.csdn.net/chengliang0315/article/details/53288524
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button mSaveSampleBtn = findViewById(R.id.save_sample_btn);
        Button mUpdateSampleBtn = findViewById(R.id.update_sample_btn);
        Button mDeleteSampleBtn = findViewById(R.id.delete_sample_btn);
        Button mQuerySampleBtn = findViewById(R.id.query_sample_btn);
        mSaveSampleBtn.setOnClickListener(this);
        mUpdateSampleBtn.setOnClickListener(this);
        mDeleteSampleBtn.setOnClickListener(this);
        mQuerySampleBtn.setOnClickListener(this);


//        //必须先初始化
//        DataUtils.initHelper(this,"user.db");
        //创建学生类
//        Student student1 = new Student("张三","1001",12);
//        // 将学生类保存到数据库
//        DbHelper.getInstance().save(student1);

//        List<Student> list = new ArrayList<>();
//        list.add(new Student("李四","1002",13));
//        list.add(new Student("王五","1003",23));
//        list.add(new Student("赵六","1004",21));
//        list.add(new Student("钱七","1005",20));
//        DbHelper.getInstance().saveAll(list);
//        List<Student> list1 = DbHelper.getInstance().queryAll(Student.class);
//        Log.d("TAG", "onCreate Student: " + list1.size());
//        for (Student student : list1) {
//            Log.d("TAG", "onCreate Student: " + student);
//        }
//
//        List<Person> list_person = new ArrayList<>();
//        list_person.add(new Person("aa","1002",13));
//        list_person.add(new Person("bb","1003",23));
//        list_person.add(new Person("cc","1004",21));
//        list_person.add(new Person("dd","1005",20));
//        DbHelper.getInstance().saveAll(list_person);
//        List<Person> list2 = DbHelper.getInstance().queryAll(Person.class);
//        Log.d("TAG", "onCreate Person: " + list2.size());
//        for (Person person : list2) {
//            Log.d("TAG", "onCreate Person: " + person);
//        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save_sample_btn:
                SaveSampleActivity.actionStart(this);
                break;
            case R.id.update_sample_btn:
                UpdateSampleActivity.actionStart(this);
                break;
            case R.id.delete_sample_btn:
                DeleteSampleActivity.actionStart(this);
                break;
            case R.id.query_sample_btn:
                QuerySampleActivity.actionStart(this);
                break;
            default:
                break;
        }
    }
}
