# Sample-Java-AutoStart
Sample auto start on boot 

sample from https://stackoverflow.com/questions/6391902/how-do-i-start-my-app-on-startup

First, you need the permission in your AndroidManifest.xml:

<uses-permission android:name="android.permission.RECEIVE_BOOT_COMPLETED" />
Also, in yourAndroidManifest.xml, define your service and listen for the BOOT_COMPLETED action:

<service android:name=".MyService" android:label="My Service">
    <intent-filter>
        <action android:name="com.myapp.MyService" />
    </intent-filter>
</service>

<receiver
    android:name=".receiver.StartMyServiceAtBootReceiver"
    android:label="StartMyServiceAtBootReceiver">
    <intent-filter>
        <action android:name="android.intent.action.BOOT_COMPLETED" />
    </intent-filter>
</receiver>
Then you need to define the receiver that will get the BOOT_COMPLETED action and start your service.

public class StartMyServiceAtBootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Intent serviceIntent = new Intent(context, MyService.class);
            context.startService(serviceIntent);
        }
    }
}
And now your service should be running when the phone starts up.
