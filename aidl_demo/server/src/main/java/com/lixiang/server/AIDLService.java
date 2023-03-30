package com.lixiang.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * @author laibaijiang
 * @date 2023/3/30
 */
public class AIDLService extends Service {

    private String[] names = {"B神", "艹神", "基神", "J神", "翔神"};

    @Override
    public void onCreate() {
        Log.e("Server", "onCreate: ");
        super.onCreate();
    }

    private String query(int num) {
        if (num > 0 && num < 6) {
            return names[num - 1];
        }
        return null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new PersonQueryBinder();
    }

    private final class PersonQueryBinder extends IPerson.Stub {
        @Override
        public String queryPerson(int num) {
            Log.e("Server", "queryPerson: ");
            return query(num);
        }
    }
}
