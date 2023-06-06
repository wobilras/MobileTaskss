package com.example.taskss.ui.reservation;

import static androidx.core.content.PermissionChecker.checkSelfPermission;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.PermissionChecker;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.taskss.R;

import java.util.ArrayList;

public class EndOfReservation extends Fragment {
    private TextView mCountTextView;
    private static final int REQUEST_IMAGE_CAPTURE = 1;
    private ArrayList<Bitmap> mImages = new ArrayList<>();
    private ActivityResultLauncher<Intent> mStartForResult = registerForActivityResult(new
            ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            Bundle extras = result.getData().getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImages.add(imageBitmap);
            updateCountTextView();
        }
    });


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_end_of_reservation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button btnCamera = view.findViewById(R.id.btnTakePhotoEnd);
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //allowedPermission();
                dispatchTakePictureIntent();
            }
        });
        mCountTextView = view.findViewById(R.id.countOfPhoto);
        updateCountTextView();

        Bundle time = getArguments();
        Button btnEnd = view.findViewById(R.id.btnEndRes);
        btnEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_endOfReservation_to_endOfEndReservation, time);
            }
        });
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(requireActivity().getPackageManager()) != null) {
            mStartForResult.launch(takePictureIntent);
        }
    }
    private void updateCountTextView() {
        mCountTextView.setText("Кол-во выбранных фото: " + mImages.size());
    }
    private boolean allowedPermission() {
        if (checkSelfPermission(requireContext(), Manifest.permission.CAMERA)
                == PermissionChecker.PERMISSION_GRANTED) {
            return true;
        } else {
            ActivityCompat.requestPermissions(requireActivity(), new String[]{Manifest.permission.CAMERA}, 1);
            return false;
        }
    }
}