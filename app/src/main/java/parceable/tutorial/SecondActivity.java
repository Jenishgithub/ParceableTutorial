package parceable.tutorial;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

/**
 * Created by CrossoOverNepal on 3/2/2016.
 */
public class SecondActivity extends Activity {
    String name;
    String surname;
    int idx;
    ContactInfo.Address address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextactivity);

        //this activity has been sent an object cifo as a parceable object
        //now to deparcel object sent
        ContactInfo contact = getIntent().getParcelableExtra("info");
        if (contact != null) {
            name = contact.name;
            surname = contact.surname;
            idx = contact.idx;
            address = contact.address;
        }
        Log.d("crossover", "the value passed from parcelable are:" + name + surname + idx);
       

    }
}
