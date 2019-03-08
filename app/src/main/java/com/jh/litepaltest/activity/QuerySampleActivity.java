/*
 * Copyright (C)  Tony Green, Litepal Framework Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jh.litepaltest.activity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jh.litepaltest.R;
import com.jh.litepaltest.model.Singer;

import org.litepal.LitePal;

import java.util.List;

public class QuerySampleActivity extends AppCompatActivity {

	public static void actionStart(Context context) {
		Intent intent = new Intent(context, QuerySampleActivity.class);
		context.startActivity(intent);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.query_sample_layout);

		// 查询的方法，打印结果：
        // 查找单个singer, 通过id
        Singer singer = LitePal.find(Singer.class, 1);
        // 查找所有singer
        List<Singer> allSingers = LitePal.findAll(Singer.class);
		//        // 查找所有singer中年龄小于20岁的
        List<Singer> singers = LitePal.where("age < ?", "20").find(Singer.class);
        // 查找年龄大于25岁的,男
        List<Singer> singers1 = LitePal.where("age > ? and ismale = ?", "20", "0").find(Singer.class);
        // 通过sql语句查询
        Cursor cursor = LitePal.findBySQL("select * from singer where < ? and ismale = ?", "25", "0");





	}

}