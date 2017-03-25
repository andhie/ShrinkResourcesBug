package ndrlabs.shrinkresourcesbug;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.ContentResolver;
import android.net.Uri;
import android.os.Bundle;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Uri uri = Uri.parse(ContentResolver.SCHEME_ANDROID_RESOURCE + "://" + getPackageName() + "/" + R.raw.sound);
        Notification noti = new Notification.Builder(this)
                .setContentText("Notification with custom sound")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setSound(uri)
                .build();

        NotificationManager manager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        manager.notify(1, noti);
    }
}
