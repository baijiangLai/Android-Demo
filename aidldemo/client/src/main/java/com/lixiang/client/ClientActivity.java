package com.lixiang.client;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ClientActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText edit_num;
    private Button btn_query;
    private TextView txt_name;
    private IPerson iPerson;
    private PersonConnection conn = new PersonConnection();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);

        bindViews();
        //绑定远程Service
        Intent intent = new Intent();
        intent.setPackage("com.lixiang.server");
        intent.setAction("android.intent.action.AIDLService");

        boolean bindSuccess = bindService(intent, conn, BIND_AUTO_CREATE);
        Log.e("TAG", "bindSuccess: " + bindSuccess);
        btn_query.setOnClickListener(this);
    }

    private void bindViews() {
        edit_num = (EditText) findViewById(R.id.edit_num);
        btn_query = (Button) findViewById(R.id.btn_query);
        txt_name = (TextView) findViewById(R.id.txt_name);
    }

    @Override
    public void onClick(View v) {
        String number = edit_num.getText().toString();
        int num = Integer.parseInt(number);
        try {
            txt_name.setText(iPerson.queryPerson(num));
        } catch (Exception e) {
            e.printStackTrace();
        }
        edit_num.setText("");
    }

    private final class PersonConnection implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            iPerson = IPerson.Stub.asInterface(service);
            Log.i("TAG", "onServiceConnected: iPerson: " + iPerson);
        }
        @Override
        public void onServiceDisconnected(ComponentName name) {
            iPerson = null;
        }
    }
}