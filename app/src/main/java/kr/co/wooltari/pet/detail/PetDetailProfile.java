package kr.co.wooltari.pet.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import kr.co.wooltari.R;
import kr.co.wooltari.constant.Const;
import kr.co.wooltari.domain.PetDummy;
import kr.co.wooltari.pet.PetProfileActivity;
import kr.co.wooltari.util.LoadUtil;

/**
 * Created by Kyung on 2017-12-07.
 */

public class PetDetailProfile {

    Activity activity;
    PetDummy.Dummy petInfo;
    GradientDrawable gd;

    private FrameLayout imagePetDetailProfileStage;
    private ImageView imagePetDetailProfile;
    private TextView textPDPSpecies, textPDPSpeciesValue;
    private TextView textPDPBreeds, textPDPBreedsValue;
    private TextView textPDPBirth, textPDPBirthValue;
    private TextView textPDPAge, textPDPAgeValue;
    private TextView textPDPHumanAge,  textPDPHumanAgeValue;
    private TextView textPDPSex, textPDPSexValue;
    private TextView textPDPNeuter, textPDPNeuterValue;
    private TextView textPDPNum, textPDPNumValue;
    private Button btnPetStateEdit;

    public PetDetailProfile(Activity activity, PetDummy.Dummy petInfo){
        this.activity = activity;

        initView();
        setProfileBackground();
        setValue(petInfo);
        setListener();
    }

    private void initView(){
        imagePetDetailProfileStage = activity.findViewById(R.id.imagePetDetailProfileStage);
        imagePetDetailProfile = activity.findViewById(R.id.imagePetDetailProfile);
        textPDPSpecies = activity.findViewById(R.id.textPDPSpecies);
        textPDPSpeciesValue = activity.findViewById(R.id.textPDPSpeciesValue);
        textPDPBreeds = activity.findViewById(R.id.textPDPBreeds);
        textPDPBreedsValue = activity.findViewById(R.id.textPDPBreedsValue);
        textPDPBirth = activity.findViewById(R.id.textPDPBirth);
        textPDPBirthValue = activity.findViewById(R.id.textPDPBirthValue);
        textPDPAge = activity.findViewById(R.id.textPDPAge);
        textPDPAgeValue = activity.findViewById(R.id.textPDPAgeValue);
        textPDPHumanAge = activity.findViewById(R.id.textPDPHumanAge);
        textPDPHumanAgeValue = activity.findViewById(R.id.textPDPHumanAgeValue);
        textPDPSex = activity.findViewById(R.id.textPDPSex);
        textPDPSexValue = activity.findViewById(R.id.textPDPSexValue);
        textPDPNeuter = activity.findViewById(R.id.textPDPNeuter);
        textPDPNeuterValue = activity.findViewById(R.id.textPDPNeuterValue);
        textPDPNum = activity.findViewById(R.id.textPDPNum);
        textPDPNumValue = activity.findViewById(R.id.textPDPNumValue);
        btnPetStateEdit = activity.findViewById(R.id.btnPetStateEdit);
    }

    private void setProfileBackground(){
        gd = new GradientDrawable();
        gd.setShape(GradientDrawable.OVAL);
        imagePetDetailProfileStage.setBackground(gd);
    }

    public void setValue(PetDummy.Dummy petInfo){
        this.petInfo = petInfo;
        setColor();
        LoadUtil.circleImageLoad(activity,petInfo.pProfile,imagePetDetailProfile);
        textPDPSpeciesValue.setText("종류!!");
        textPDPBreedsValue.setText("종!!!!");
        textPDPBirthValue.setText("생년월일!!!!");
        textPDPAgeValue.setText("나이!!!!");
        textPDPHumanAgeValue.setText("사랑나이!!!!");
        textPDPSexValue.setText(petInfo.sex);
        textPDPNeuterValue.setText(petInfo.neuter);
        textPDPNumValue.setText(petInfo.petNumber);
    }

    private void setColor(){
        int petColor = LoadUtil.loadColor(activity,petInfo.color);
        textPDPSpecies.setTextColor(petColor);
        textPDPBreeds.setTextColor(petColor);
        textPDPBirth.setTextColor(petColor);
        textPDPAge.setTextColor(petColor);
        textPDPHumanAge.setTextColor(petColor);
        textPDPSex.setTextColor(petColor);
        textPDPNeuter.setTextColor(petColor);
        textPDPNum.setTextColor(petColor);
        gd.setColor(petColor);
    }

    private void setListener(){
        btnPetStateEdit.setOnClickListener(v -> {
            Intent intent = new Intent(activity, PetProfileActivity.class);
            intent.putExtra(Const.PET_ID, petInfo.pPK);
            activity.startActivityForResult(intent,Const.PET_PROFILE_EDIT);
        });
    }
}