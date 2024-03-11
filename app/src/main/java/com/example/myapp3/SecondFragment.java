package com.example.myapp3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import com.example.myapp3.databinding.FragmentSecondBinding;
import java.util.Random;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SecondFragmentArgs args = SecondFragmentArgs.fromBundle(getArguments());
        int currentCount = args.getMyArg();
        Random random = new Random();
        int randomNumber = currentCount > 0 ? random.nextInt(currentCount + 1) : 0;

        binding.textviewRandom.setText(getString(R.string.random_number, randomNumber));
        binding.textviewHeader.setText(getString(R.string.random_heading, currentCount));

        binding.buttonSecond.setOnClickListener(v ->
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
