package com.yukang.jsonparse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView output = (TextView) findViewById(R.id.textView2);
        String strJson = "{\n" +
                "    \"Employee\": [\n" +
                "        {\n" +
                "            \"id\": \"01\", \n" +
                "            \"name\": \"Gopal Varma\", \n" +
                "            \"salary\": \"500000\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"id\": \"02\", \n" +
                "            \"name\": \"Sairamkrishna\", \n" +
                "            \"salary\": \"500000\"\n" +
                "        }, \n" +
                "        {\n" +
                "            \"id\": \"03\", \n" +
                "            \"name\": \"Sathish kallakuri\", \n" +
                "            \"salary\": \"600000\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        String data = "";
        try {
            JSONObject jsonRootObject = new JSONObject(strJson);

            // Get the instance of JSONArray that contains JSONObjects
            JSONArray jsonArray = jsonRootObject.getJSONArray("Employee");

            // Iterate the jsonArray and print the info of JSONObjects
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = Integer.parseInt(jsonObject.optString("id"));
                String name = jsonObject.optString("name");
                float salary = Float.parseFloat(jsonObject.optString("salary"));

                data += "Node" + i + " : \n\t\t\t\t id = " + id + " \n\t\t\t\t Name = " + name + " \n\t\t\t\t Salary = " + salary + "\n";
            }
            output.setText(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
