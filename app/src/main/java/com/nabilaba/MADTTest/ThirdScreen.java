package com.nabilaba.MADTTest;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.nabilaba.MADTTest.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThirdScreen extends AppCompatActivity {
// Billionaires json url
    private static final String url = "https://reqres.in/api/users?page=1&per_page=10";
    private ProgressDialog wait;
    private List<Data> dataList = new ArrayList<Data>();
    private ListView listView;
    private CustomListAdapter adapter;
    SwipeRefreshLayout refresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_screen);

        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        centerToolbarTitle(toolbar);

        Nabil();

        refresh = findViewById(R.id.refresh);
        refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                @Override
                public void onRefresh() {
                    dataList.clear();
                    Nabil();
                    refresh.setRefreshing(false);
                }
            });
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return super.onSupportNavigateUp();
    }

    public void Nabil() {
        final TextView state = findViewById(R.id.state);
        
        listView = (ListView) findViewById(R.id.list);
        adapter = new CustomListAdapter(this, dataList);
        listView.setAdapter(adapter);

        wait = new ProgressDialog(this);
        wait.setMessage("Loading...");
        wait.show();

        JsonObjectRequest dataReq = new JsonObjectRequest(url, new com.android.volley.Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    hideWaitDialog();

                    try { 
                        JSONArray jsonArray = response.getJSONArray("data");
                        if (jsonArray.length() > 0) {
                            state.setVisibility(View.GONE);
                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject obj = jsonArray.getJSONObject(i);

                                Data data = new Data();
                                data.setName(obj.getString("first_name") + " " + obj.getString("last_name"));
                                data.setAvatarUrl(obj.getString("avatar"));
                                data.setWorth(obj.getString("email"));

                                dataList.add(data);
                            }
                        } else {
                            state.setVisibility(View.VISIBLE);
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    adapter.notifyDataSetChanged();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    hideWaitDialog();
                }
            });

        AppController.getInstance().addToRequestQueue(dataReq);
    }

    @Override
    protected void onDestroy() {
        hideWaitDialog();
        super.onDestroy();
    }


    private void hideWaitDialog() {
        if (wait != null) {
            wait.dismiss();
            wait = null;
        }
    }

    static void centerToolbarTitle(@NonNull final Toolbar toolbar) {
        final CharSequence title = toolbar.getTitle();
        final ArrayList<View> outViews = new ArrayList<>(1);
        toolbar.findViewsWithText(outViews, title, View.FIND_VIEWS_WITH_TEXT);
        if (!outViews.isEmpty()) {
            final TextView titleView = (TextView) outViews.get(0);
            titleView.setGravity(Gravity.CENTER);
            final Toolbar.LayoutParams layoutParams = (Toolbar.LayoutParams) titleView.getLayoutParams();
            layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
            toolbar.requestLayout();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.info, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.dev:
                Intent dev = new Intent();
                dev.setAction(Intent.ACTION_VIEW);
                dev.addCategory(Intent.CATEGORY_BROWSABLE);
                dev.setData(Uri.parse("https://api.whatsapp.com/send?phone=+6283146542084"));
                startActivity(dev);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
