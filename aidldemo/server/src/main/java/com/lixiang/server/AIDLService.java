package com.lixiang.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

import androidx.annotation.Nullable;

import com.lixiang.client.IPerson;

public class AIDLService extends Service {

    private IBinder binder = new PersonQueryBinder();
    private String[] names = {"B神","艹神","基神","J神","翔神"};

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.i("AIDLService", "onBind: ");
        return binder;
    }

    private final class PersonQueryBinder extends IPerson.Stub{

        @Override
        public String queryPerson(int num) throws RemoteException {
            return query(num);
        }
    }

    private String query(int num) {
        if (num > 0 && num < 6){
            return names[num - 1];
        }
        return null;
    }
}
