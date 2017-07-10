package me.seebrock3r.bertha;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView iconView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iconView = findViewById(R.id.image);

        Intent intent = getIntent();
        setIconFrom(intent);
    }

    public void setIconFrom(Intent intent) {
        Uri uri = intent.getData();
        if (uri == null) {
            return;
        }

        String host = uri.getHost();
        switch (host) {
            case "banana":
                iconView.setImageResource(R.drawable.ic_shortcut_banana_foreground);
                break;
            case "strawberry":
                iconView.setImageResource(R.drawable.ic_shortcut_strawberry_foreground);
                break;
            default:
                Log.e("Bertha", "Invalid deeplink: " + uri);
        }
    }
}
