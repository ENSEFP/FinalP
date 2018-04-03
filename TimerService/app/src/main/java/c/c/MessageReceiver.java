package c.c;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

/**
 * Created by chenxiaojie on 2018-03-27.
 */
@SuppressLint("ParcelCreator")
public class MessageReceiver extends ResultReceiver {

    private  MainActivity.Message message;

    public MessageReceiver(MainActivity.Message message){
        super(new Handler());

        this.message = message;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        message.displayMessage(resultCode, resultData);
    }
}
