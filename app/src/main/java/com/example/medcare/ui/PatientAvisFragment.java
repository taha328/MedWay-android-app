package com.example.medcare.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.medcare.R;

public class PatientAvisFragment extends Fragment {

    private EditText editAvis;
    private RatingBar ratingBar;
    private Button btnEnvoyer;

    public PatientAvisFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_avis_patient, container, false);

        editAvis = view.findViewById(R.id.editAvis);
        ratingBar = view.findViewById(R.id.ratingBar);
        btnEnvoyer = view.findViewById(R.id.btnEnvoyerAvis);

        btnEnvoyer.setOnClickListener(v -> envoyerAvis());

        return view;
    }

    private void envoyerAvis() {
        String commentaire = editAvis.getText().toString().trim();
        float note = ratingBar.getRating();

        if (TextUtils.isEmpty(commentaire)) {
            Toast.makeText(getContext(), "Veuillez entrer un commentaire", Toast.LENGTH_SHORT).show();
            return;
        }

        // Ici tu pourrais enregistrer l'avis dans une base locale ou Firestore, par exemple
        Toast.makeText(getContext(), "Merci pour votre avis !", Toast.LENGTH_LONG).show();

        // Réinitialiser les champs
        editAvis.setText("");
        ratingBar.setRating(0);
    }
}
