package spartacode.com.playfragment;

import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements FragmentA.CommunicateFrag{

    FragmentA fragmentA = new FragmentA();
    FragmentB fragmentB = new FragmentB();
    FragmentManager fm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.layout_container,fragmentB,"fragment2").commit();
        fm.beginTransaction().add(R.id.layout_container,fragmentA,"fragment1").commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_settings:
                Log.e("Yes", "onOptionsItemSelected: ");
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public void sendData(String data) {
        fragmentB =(FragmentB) fm.findFragmentByTag("fragment2");
        Log.e("MainActivity",data);
        fragmentB.recieveData(data);
    }
}
