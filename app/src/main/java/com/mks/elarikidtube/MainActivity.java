package com.mks.elarikidtube;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mks.elarikidtube.api.RestApi;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    private Disposable disposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*disposable = RestApi.youtube()
                .getResults("snippet", "cats", "50", "video")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(results -> {
                    int t = 0;
                });*/

        disposable = RestApi.youtube()
                .getRelatedVideos("snippet", "CFjSm-dzSCI", "video")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(results -> {
                    int t = 0;
                });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        if (disposable != null && !disposable.isDisposed()) {
            disposable.dispose();
            disposable = null;
        }
    }
}
