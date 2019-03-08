package com.jh.litepaltest.db;

import android.util.Log;

import com.jh.litepaltest.model.Singer;
import com.jh.litepaltest.model.Song;
import com.jh.litepaltest.model.TestA;

import org.litepal.LitePal;

import java.util.Collection;
import java.util.List;

/**
 * 数据库的工具类
 */
public class DbHelper implements IOpenHelper {

    private static DbHelper instance;

    static {
        instance = new DbHelper();
    }

    public static DbHelper getInstance() {
        return instance;
    }


    @Override
    public void save(Object obj) {
        if (obj instanceof Singer){
            Singer singer = (Singer) obj;
            singer.save();
            Log.e("TAG", "保存成功1 =" + singer);
        }else if (obj instanceof TestA){
            TestA student = (TestA) obj;
            student.save();
            Log.e("TAG", "保存成功2 =" + student);
        }else if (obj instanceof Song){
            Song song = (Song) obj;
            song.save();
            Log.e("TAG", "保存成功3 =" + song);
        }
    }

    @Override
    public void saveAll(Collection collection) {
        LitePal.saveAll(collection);
        Log.e("TAG", "保存成功 =" + collection.size());

    }

    @Override
    public <T> List<T> queryAll(Class<T> table) {
        return LitePal.findAll(table);
    }

    @Override
    public <T> List<T> queryAll(Class<T> table, String order) {
        return null;
    }

    @Override
    public <T> List<T> queryAll(Class<T> table, String order, int limit) {
        return null;
    }

    @Override
    public <T> T queryById(Class<T> table, Object id) {
        return null;
    }

    @Override
    public void clear(Class table) {

    }

    @Override
    public void delete(Object obj) {

    }

    @Override
    public void deleteAll(Collection collection) {

    }

    public static <Model> void save(final Class<Model> tClass,
                                    final Model... models) {
        if (models == null || models.length == 0)
            return;
        try {
            Singer singer = (Singer) tClass.newInstance();
            singer.save();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    /**
     * 删除数据
     */
    public static void delete() {

    }

    /**
     * 更新数据
     */
    public static void update() {

    }

    public static int update(Singer singer, long updateId) {
        return singer.update(updateId);
    }

    /**
     * 查询数据
     */
    public static void query() {

    }
}
