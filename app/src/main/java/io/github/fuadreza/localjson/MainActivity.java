package io.github.fuadreza.localjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.github.fuadreza.localjson.utils.JSONParser;

public class MainActivity extends AppCompatActivity {
    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) findViewById(R.id.list);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObject = new JSONObject();
        try{
            jsonObject = new JSONObject(jsonParser.loadJSONFromAsset(this));
        }catch (JSONException e) {
            e.printStackTrace();
        }

        ArrayList<HashMap<String,String >> arrayList = convertJSON(jsonObject);

        ArrayList<String> ale = new ArrayList<String>();

        for (int i = 0; i < arrayList.size();i++){
            ale.add(arrayList.get(i).get("judul"));
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                ale
                );
        lv.setAdapter(arrayAdapter);

    }

    private ArrayList<HashMap<String, String>> convertJSON(JSONObject jsonObject){
        ArrayList<HashMap<String, String>> formList =new ArrayList<>();
        try {
            JSONObject obj = jsonObject;
            JSONArray m_jArry = obj.getJSONArray("artikel");
//            formList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> m_li;

            for (int i = 0; i < m_jArry.length(); i++) {
                JSONObject jo_inside = m_jArry.getJSONObject(i);
                Log.d("Details-->", jo_inside.getString("id"));
                String id = jo_inside.getString("id");
                String kategori = jo_inside.getString("kategori");
                String judul = jo_inside.getString("judul");
                String konten = jo_inside.getString("konten");

//                Add your values in your `ArrayList` as below:
                m_li = new HashMap<String, String>();
                m_li.put("id", id);
                m_li.put("kategori", kategori);
                m_li.put("judul", judul);
                m_li.put("konten", konten);

                formList.add(m_li);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return formList;
    }
}
