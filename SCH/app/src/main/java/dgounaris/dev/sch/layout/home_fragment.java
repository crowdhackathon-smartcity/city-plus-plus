package dgounaris.dev.sch.layout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import dgounaris.dev.sch.People.Person;
import dgounaris.dev.sch.R;

public class home_fragment extends Fragment {

    private Person activeperson;

    PopupWindow popUpWindow;
    ViewGroup.LayoutParams layoutParams;
    LinearLayout containerLayout;
    TextView tvMsg;
    boolean isClicked = true;

    public home_fragment() {
        // Required empty public constructor
    }

    public static home_fragment newInstance() {
        home_fragment fragment = new home_fragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activeperson = (Person) getArguments().getSerializable("activeperson");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final View view = inflater.inflate(R.layout.fragment_home_fragment, container, false);

        popUpWindow = new PopupWindow(getContext());

        ImageButton button = (ImageButton) view.findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isClicked) {
                    isClicked = false;
                    popUpWindow.showAtLocation(view, Gravity.TOP,0,350);
                    //popUpWindow.update(500,250);
                } else {
                    isClicked = true;
                    popUpWindow.dismiss();
                }

                //popUpWindow.setContentView();
            }
        });


        tvMsg = new TextView(getContext());
        tvMsg.setText("Connecting...");
        tvMsg.setTextSize(20);
        Drawable circle = getResources().getDrawable(R.drawable.circle);
        //tvMsg.setBackground(circle);



        containerLayout = new LinearLayout(getContext());

        layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        containerLayout.setOrientation(LinearLayout.VERTICAL);
        containerLayout.addView(tvMsg, layoutParams);
        containerLayout.setBackgroundColor(getResources().getColor(R.color.darkgreen));
        popUpWindow.setContentView(containerLayout);

        return view;

    }

    private void onBinConnection() {

    }

}