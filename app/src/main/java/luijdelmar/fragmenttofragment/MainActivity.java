package luijdelmar.fragmenttofragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OneFragment.OneFragmentListener, SecondFragment.SecondFragmentListener {
    private OneFragment oneFragment;
    private SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        oneFragment = new OneFragment();
        secondFragment = new SecondFragment();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_one, oneFragment)
                .replace(R.id.container_second, secondFragment)
                .commit();
    }

    @Override
    public void onOneInputSent(CharSequence input) {
        secondFragment.updateEditText(input);
    }

    @Override
    public void onSecondInputSent(CharSequence input) {
        oneFragment.updateEditText(input);
    }
}
