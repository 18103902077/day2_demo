package com.example.day2_demo;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.example.day2_demo.base.HttpManager;
import com.example.day2_demo.bean.BaseResponse;
import com.example.day2_demo.bean.ListData;
import com.example.day2_demo.utiles.MyService;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

import butterknife.internal.Utils;
import io.reactivex.functions.Consumer;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.day2_demo", appContext.getPackageName());
    }
     private static final String TAG = "tag";
   @Test
    public void test(){
        HttpManager.getInstance().getServer(MyService.class).getData("wxarticle/chapters/json")
                .compose(HttpManager.getInstance().<BaseResponse<List<ListData>>>getFormer())
                .compose(HttpManager.getInstance().<List<ListData>>changeResult())
                .subscribe(new Consumer<List<ListData>>() {
                    @Override
                    public void accept(List<ListData> listData) throws Exception {
                        Log.d(TAG, "accept: ========"+listData.toString());
                    }
                });
    }
}
