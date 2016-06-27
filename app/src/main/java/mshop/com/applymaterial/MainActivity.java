package mshop.com.applymaterial;

import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import mshop.com.adapter.RecyclerAdapter;
import mshop.com.model.LandScape;


public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_clipped_drawer);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        toolbar.setTitle("MobStores");

        toolbar.setNavigationIcon(R.drawable.ic_menu);

        toolbar.inflateMenu(R.menu.menu_main);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String msg;

                switch (item.getItemId()) {
                    case R.id.add:
                        msg = "Add menu";
                        break;
                    case R.id.search:
                        msg = "Search menu";
                        break;
                    default:
                        msg = "Menu Options";
                }

                Toast.makeText(getBaseContext(), msg + " clicked!", Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        setUpDrawer();

        setUpRecyclerView();
    }

    private void setUpDrawer() {

        NavigationDrawerFragment drawerFragment = (NavigationDrawerFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_drwr_fragment);

        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerFragment.setUpDrawer(R.id.nav_drwr_fragment, drawerLayout, toolbar);

    }

    private void setUpRecyclerView() {
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, LandScape.getData());
        recyclerView.setAdapter(recyclerAdapter);

        LinearLayoutManager mLinearLayout = new LinearLayoutManager(this);
        mLinearLayout.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(mLinearLayout);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }


    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        String msg;

        switch (item.getItemId()) {
            case R.id.add:
                msg = "Add menu";
                break;
            case R.id.search:
                msg = "Search menu";
                break;
            default:
                msg = "Menu Options";
        }

        Toast.makeText(this, msg + " clicked!", Toast.LENGTH_SHORT).show();

        return super.onOptionsItemSelected(item);
    }*/
}
