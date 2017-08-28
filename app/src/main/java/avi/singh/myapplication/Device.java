package avi.singh.myapplication;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;

public class Device extends AppCompatActivity {


    ListView listView;
    String [] items;
    ArrayList<File> mySongs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);

        listView = findViewById(R.id.device_read_storage);

        mySongs = findSongs(Environment.getExternalStorageDirectory());

        items = new String[mySongs.size()];

            for (int i = 0 ; i <mySongs.size(); i++){

                items[i] = mySongs.get(i).getName().toString();
            }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.songs_directory,R.id.textView2,items);
        listView.setAdapter(arrayAdapter);




    }

    public ArrayList<File> findSongs(File root) {

        ArrayList<File> arrayList = new ArrayList<File>();


        File[] files = root.listFiles();

        for (File singleFile : files) {

            if (singleFile.isDirectory() && !singleFile.isHidden()) {

               arrayList.addAll( findSongs(singleFile));


            } else {
                if (singleFile.getName().endsWith(".mp3") || singleFile.getName().endsWith(".wav") ) {

                    arrayList.add(singleFile);
                }
            }

        }
        return arrayList;
    }



}
