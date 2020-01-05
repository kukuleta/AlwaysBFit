package com.example.alwaysbfit;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;


public class ExerciseDetailFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    Exercise exercise;

    private OnFragmentInteractionListener mListener;

    public ExerciseDetailFragment() {
    }

    public static ExerciseDetailFragment newInstance(Exercise exercise) {
        ExerciseDetailFragment fragment = new ExerciseDetailFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1,exercise);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            exercise = (Exercise) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_exercise_detail, container, false);
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView txtName = (TextView)view.findViewById(R.id.exercise_name);
        txtName.setText(exercise.getName());
        TextView txtDescriptipn = (TextView)view.findViewById(R.id.exercise_description);
        txtDescriptipn.setText(exercise.getDescription());
        txtDescriptipn.setEnabled(false);
        /*listView.setAdapter(new ArrayAdapter<String>(getActivity(), R.layout.array_adapter,
                movie.getStars().toArray(new String[1])));*/
    }

    public void setMovie( Exercise exercise, View view) {
        this.exercise = exercise;
        TextView txtName = (TextView)view.findViewById(R.id.exercise_name);
        txtName.setText(exercise.getName());
        TextView txtDescription = (TextView) view.findViewById(R.id.exercise_description);
        txtDescription.setText(exercise.getDescription());
        txtDescription.setEnabled(false);

    }
}
