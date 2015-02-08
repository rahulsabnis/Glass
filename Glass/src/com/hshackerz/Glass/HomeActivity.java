package com.hshackerz.Glass;

//        import android.app.Activity;
//        import android.content.Intent;
//        import android.graphics.Camera;
//        import android.graphics.Point;
//        import android.os.Bundle;
//        import android.provider.MediaStore;
//        import android.view.Display;
//        import android.widget.Button;
//        import android.widget.EditText;
//        import android.net.Uri;
//        import android.widget.VideoView;

        import android.app.Activity;
        import android.content.ContentResolver;
        import android.content.Intent;
        import android.database.Cursor;
        import android.os.Bundle;
        import android.provider.ContactsContract;
        import android.view.Menu;
        import android.view.MenuInflater;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.*;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.HashMap;
        import java.util.HashMap;
        import java.util.Objects;

        import android.app.Activity;
        import android.os.Bundle;
        import android.text.Editable;
        import android.text.TextWatcher;
        import android.widget.ArrayAdapter;
        import android.widget.EditText;
        import android.widget.ListView;

/**
 * Created on 2/7/2015.
 */
public class HomeActivity extends Activity {
    String phoneNumber;
    ListView lv;
    ArrayList <String> names = new ArrayList<String>();
    ArrayList <String> numbers = new ArrayList<String>();
    HashMap<String, String> map = new HashMap<String, String>();
    Activity home = this;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        lv= (ListView) findViewById(R.id.lv);
        getNumber(this.getContentResolver());
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent goToMessaging = new Intent(home, MessagingActivity.class);
                String number = map.get(names.get(position));
                goToMessaging.putExtra("phone number", number);
                goToMessaging.putExtra("name", names.get(position));
                startActivity(goToMessaging);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_activity_actions, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle presses on the action bar items
        switch (item.getItemId()) {
            case R.id.newMessage:
                Intent goToMessaging = new Intent(home, MessagingActivity.class);
                startActivity(goToMessaging);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void getNumber(ContentResolver cr)
    {
        Cursor phones = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null,null,null, null);
        while (phones.moveToNext())
        {
            String name=phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
            phoneNumber = phones.getString(phones.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
            map.put(name, phoneNumber);
            names.add(name);
            numbers.add(phoneNumber);
            Collections.sort(names);
        }
        phones.close();// close cursor
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        lv.setAdapter(adapter);
        //display contact numbers in the list
    }
}


//    public class DisplayMessageActivity extends ActionBarActivity {
//
//        @Override
//        protected void onCreate(Bundle savedInstanceState) {
//            super.onCreate(savedInstanceState);
//            setContentView(R.layout.activity_display_message);
//
//            if (savedInstanceState == null) {
//                getSupportFragmentManager().beginTransaction()
//                        .add(R.id.container, new PlaceholderFragment()).commit();
//            }
//        }
//
//        @Override
//        public boolean onOptionsItemSelected(MenuItem item) {
//            // Handle action bar item clicks here. The action bar will
//            // automatically handle clicks on the Home/Up button, so long
//            // as you specify a parent activity in AndroidManifest.xml.
//            int id = item.getItemId();
//            if (id == R.id.action_settings) {
//                return true;
//            }
//            return super.onOptionsItemSelected(item);
//        }
//
//        /**
//         * A placeholder fragment containing a simple view.
//         */
//        public static class PlaceholderFragment extends Fragment {
//
//            public PlaceholderFragment() { }
//
//            @Override
//            public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                                     Bundle savedInstanceState) {
//                View rootView = inflater.inflate(R.layout.fragment_display_message,
//                        container, false);
//                return rootView;
//            }
//        }
