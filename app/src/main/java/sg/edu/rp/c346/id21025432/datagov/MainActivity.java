package sg.edu.rp.c346.id21025432.datagov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class MainActivity extends AppCompatActivity {

    ListView lvSpent;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvSpent = findViewById(R.id.lvSpent);
        client = new AsyncHttpClient();

    }

    @Override
    protected void onResume() {
        super.onResume();

        ArrayList<yearSpent> alSpent = new ArrayList<yearSpent>();

        client.get("https://data.gov.sg/api/action/datastore_search?resource_id=79a62357-49ec-4d78-9d00-50b0cf73084c&limit=20", new JsonHttpResponseHandler() {

            int year;
            int totalSpent;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                super.onSuccess(statusCode, headers, response);
                try {
                    JSONObject jsonArrResult = response.getJSONObject("result");
                    JSONArray jsonArrRecords = jsonArrResult.getJSONArray("records");
                    for(int i = 0; i < jsonArrRecords.length(); i++) {
                        JSONObject jsonObjRecord = jsonArrRecords.getJSONObject(i);
                        year = jsonObjRecord.getInt("year");
                        totalSpent = jsonObjRecord.getInt("total_expenditure_on_education");
                        yearSpent ys = new yearSpent(year, totalSpent);
                        alSpent.add(ys);
                    }
                }

                catch(JSONException e){

                }
                ArrayAdapter a = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,alSpent);
                lvSpent.setAdapter(a);



            }//end onSuccess
        });
    }//end onResume
}