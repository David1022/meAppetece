package com.appdesigndm.meappetece;


import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UnlockFragment extends Fragment {

    private Context mContext;
    private ImageView mImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_unlock, container, false);
        mContext = getContext();

        init(view);
        animateOnCreateViews(view);

        return view;
    }

    private void animateOnCreateViews(View view) {
        Animation animation = AnimationUtils.loadAnimation(mContext, R.anim.animation_splash_icon);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                unlockDelay();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        mImage.startAnimation(animation);

    }

    private void init(View view) {
        mImage = (ImageView) view.findViewById(R.id.imagen_unlock);
    }

    private void unlockDelay() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FinalFragment()).commit();
            }
        }, 300);

    }

}
