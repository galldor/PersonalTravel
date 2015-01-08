package br.com.forukode.matheusmartins.personaltravel.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import br.com.forukode.matheusmartins.personaltravel.R;
import br.com.forukode.matheusmartins.personaltravel.dao.UserDAO;
import br.com.forukode.matheusmartins.personaltravel.entity.User;

/**
 * Created by matheusmartins on 12/31/14.
 */
public class RegisterActivity extends Activity {

    public static final int MEDIA_TYPE_IMAGE = 1;
    public static final int MEDIA_TYPE_VIDEO = 2;
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    View.OnClickListener onclickOnIsConsultantCheckBox = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getIsConsultantCheckBox().isChecked()) {
                spinnerEnable(true);
            } else {
                spinnerEnable(false);
            }
        }
    };
    View.OnClickListener onClickOnProfilePicture = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            openContextMenu(v);
        }
    };
    View.OnClickListener buttonRegisterClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            dao.insert(userFromForm().toContentValeus());
        }
    };
    private ImageView profilePicture;
    private UserDAO dao;
    private Uri fileUri;
    MenuItem.OnMenuItemClickListener onMenuClickOnTakePictureContextMenu = new MenuItem.OnMenuItemClickListener() {
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            // create Intent to take a picture and return control to the calling application
            Intent goToCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);


            fileUri = getOutputMediaFileUri(MEDIA_TYPE_IMAGE, getResources().getString(R.string.app_name)); // create a file to save the image
            Log.d("Personal Travel", fileUri.getPath());
            goToCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri); // set the image file name

            // start the image capture Intent
            startActivityForResult(goToCameraIntent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            return false;
        }
    };

    /**
     * Create a file Uri for saving an image or video
     */
    private static Uri getOutputMediaFileUri(int type, String directoryFolder) {
        return Uri.fromFile(getOutputMediaFile(type, directoryFolder));
    }

    /**
     * Create a File for saving an image or video
     */
    private static File getOutputMediaFile(int type, String directoryFolder) {
        // To be safe, you should check that the SDCard is mounted
        // using Environment.getExternalStorageState() before doing this.
        File mediaStorageDir = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), directoryFolder);
        // This location works best if you want the created images to be shared
        // between applications and persist after your app has been uninstalled.

        // Create the storage directory if it does not exist
        if (!mediaStorageDir.exists()) {
            if (!mediaStorageDir.mkdirs()) {
                Log.d("PersonalTravel", "failed to create directory");
                return null;
            }
        }

        if (mediaStorageDir.exists()) {
            Log.d("Personal Travel", "Storage created");
        }


        // Create a media file name
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        Log.d("Personal Travel", "timeStamp: " + String.valueOf(timeStamp));
        File mediaFile;
        if (type == MEDIA_TYPE_IMAGE) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "IMG_" + timeStamp + ".jpg");
            Log.d("Personal Travel", "Media type image.");
        } else if (type == MEDIA_TYPE_VIDEO) {
            mediaFile = new File(mediaStorageDir.getPath() + File.separator +
                    "VID_" + timeStamp + ".mp4");
            Log.d("Personal Travel", "Media type video.");
        } else {
            return null;
        }

        return mediaFile;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);
        Spinner spinner = getCountrySpinner();
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_arrays, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        getIsConsultantCheckBox().setOnClickListener(onclickOnIsConsultantCheckBox);
        spinnerEnable(false);
        profilePicture = (ImageView) findViewById(R.id.register_layout_profile_picture);
        profilePicture.setOnClickListener(onClickOnProfilePicture);
        registerForContextMenu(profilePicture);
        dao = new UserDAO(this);
        findViewById(R.id.register_layout_register_button).setOnClickListener(buttonRegisterClickListener);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.add(R.string.register_layout_context_menu_take_picture).setOnMenuItemClickListener(onMenuClickOnTakePictureContextMenu);
        menu.add(R.string.register_layout_context_menu_choose_from_galery);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    private CheckBox getIsConsultantCheckBox() {
        return (CheckBox) findViewById(R.id.register_layout_is_user_consultant_checkbox);
    }

    private Spinner getCountrySpinner() {
        return (Spinner) findViewById(R.id.register_layout_country_spinner);
    }

    private void spinnerEnable(Boolean trueOrFalse) {
        Spinner spinnerAux = getCountrySpinner();
        spinnerAux.setEnabled(trueOrFalse);
        spinnerAux.setClickable(trueOrFalse);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                loadImage(fileUri.getPath());
            } else if (resultCode == RESULT_CANCELED) {
                // User cancelled the image capture
            } else {
                // Image capture failed, advise user

            }
        }
        //super.onActivityResult(requestCode, resultCode, data);
    }

    public void loadImage(String fileDirectory) {
        Bitmap image = BitmapFactory.decodeFile(fileDirectory);
        //Bitmap reducedImage = Bitmap.createScaledBitmap(image,80,80,true);
        profilePicture.setImageBitmap(image);

    }

    public User userFromForm() {
        User userRegistered = new User();
        userRegistered.firstName = ((EditText) findViewById(R.id.register_layout_input_first_name)).toString();
        userRegistered.lastName = ((EditText) findViewById(R.id.register_layout_input_last_name)).toString();
        userRegistered.email = ((EditText) findViewById(R.id.register_layout_input_email)).toString();
        userRegistered.phoneNumber = ((EditText) findViewById(R.id.register_layout_input_phone)).toString();
        userRegistered.password = ((EditText) findViewById(R.id.register_layout_input_password)).toString();
        userRegistered.profileImageUrl = fileUri.toString();
        Boolean checkBoxIsConsultant = getIsConsultantCheckBox().isChecked();
        if (checkBoxIsConsultant) {
            userRegistered.isConsultant = 1;
            userRegistered.countryThatIsConsultant = getCountrySpinner().getSelectedItem().toString();
        } else {
            userRegistered.isConsultant = 0;
        }
        return userRegistered;
    }
}
