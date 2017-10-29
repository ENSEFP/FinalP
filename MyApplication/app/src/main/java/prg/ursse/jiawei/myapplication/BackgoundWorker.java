package prg.ursse.jiawei.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by david on 2017/10/29.
 */

public class BackgoundWorker extends AsyncTask<String, Void, String > {

    Context info;
    BackgoundWorker(Context info)
    {
        this.info = info;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String result) {
        Toast.makeText(info,result,Toast.LENGTH_LONG).show();
    }

    @Override
    protected String doInBackground(String... params) {
        String reg_url = "";
        String login_url = "";
        String method = params[0];
        if(method.equals("Register"))
        {
            String email = params[1];
            String password = params[2];
            String password2 = params[3];

            try {
                URL url = new URL (reg_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                OutputStream OS = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(OS, "UTF-8"));

                String data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email,"UTF-8") + "&" +
                        URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password,"UTF-8") + "&" +
                        URLEncoder.encode("password2", "UTF-8") + "=" + URLEncoder.encode(password2,"UTF-8");

                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();

                OS.close();
                InputStream IS = httpURLConnection.getInputStream();
                IS.close();
                return "Register successfully";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
